/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.javacnam.domotique.servlets;

import fr.javacnam.domotique.beans.Piece;
import fr.javacnam.domotique.dao.DaoFactory;
import fr.javacnam.domotique.dao.PieceDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajaonson
 */
public class Configuration extends HttpServlet {

    private PieceDao pieceDao;

    @Override
    public void init() throws ServletException {
        DaoFactory daoFactory;
        try {
            daoFactory = DaoFactory.getInstance();
            this.pieceDao = daoFactory.getPieceDao();
        } catch (SQLException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ServletContext contexte = getServletContext();
        RequestDispatcher dispatcher;

        Auth auth = new Auth();
        boolean isAuth = auth.isAuth(session);

        if (isAuth) {
            dispatcher = contexte.getRequestDispatcher("/jsp/configuration.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Auth");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexte = getServletContext();
        RequestDispatcher dispatcher;

        // Données session
        HttpSession session = request.getSession();
        Auth auth = new Auth();
        boolean isAuth = auth.isAuth(session);

        if (isAuth) {
            // Récupération de la liste des pièces
            String user = (String) session.getAttribute("user");
            List<Piece> pieces = this.pieceDao.getAllPieces(user);

            session.setAttribute("userPieces", pieces);

            dispatcher = contexte.getRequestDispatcher("/jsp/configuration.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Auth");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext contexte = getServletContext();
        RequestDispatcher dispatcher;

        // Données session
        HttpSession session = request.getSession();
        Auth auth = new Auth();
        boolean isAuth = auth.isAuth(session);

        if (isAuth) {
            String user = (String) session.getAttribute("user");

            // Si post piece
            String addPiece = request.getParameter("addPiece");
            // Vérification si post vient de add-piece
            if (addPiece != null) {
                String nomPiece = request.getParameter("nomPiece");

                // Vérification si nomPiece non null
                if (nomPiece != null) {
                    // Création
                    System.out.println("CREATION : " + user + " " + nomPiece);
                    this.pieceDao.createPiece(user, nomPiece);
                }
            }

            // Récupération de la liste des pièces
            List<Piece> pieces = this.pieceDao.getAllPieces(user);

            session.setAttribute("userPieces", pieces);

            dispatcher = contexte.getRequestDispatcher("/jsp/configuration.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Auth");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
