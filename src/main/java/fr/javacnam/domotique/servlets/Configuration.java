/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.javacnam.domotique.servlets;

import fr.javacnam.domotique.beans.Equipement;
import fr.javacnam.domotique.beans.Piece;
import fr.javacnam.domotique.beans.TypeEquipement;
import fr.javacnam.domotique.dao.DaoFactory;
import fr.javacnam.domotique.dao.EquipementDao;
import fr.javacnam.domotique.dao.PieceDao;
import fr.javacnam.domotique.dao.TypeEquipementDao;
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
    private EquipementDao equipementDao;
    private TypeEquipementDao typeEquipementDao;

    @Override
    public void init() throws ServletException {
        DaoFactory daoFactory;
        try {
            daoFactory = DaoFactory.getInstance();
            this.pieceDao = daoFactory.getPieceDao();
            this.equipementDao = daoFactory.getEquipementDao();
            this.typeEquipementDao = daoFactory.getTypeEquipementDao();
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
            // Récupération du user connecté
            String user = (String) session.getAttribute("user");

            // Récupération de la liste des types d'équopement
            List<TypeEquipement> typesEquipement = this.typeEquipementDao.getAllTypeEquipement();
            session.setAttribute("typesEquipement", typesEquipement);

            // Récupération de la liste des pièces
            List<Piece> pieces = this.pieceDao.getAllPieces(user);
            session.setAttribute("userPieces", pieces);

            // Récupération de la liste des équipements
            List<Equipement> equipements = this.equipementDao.getAllEquipements(user);
            session.setAttribute("userEquipements", equipements);

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
            String ajouterPiece = request.getParameter("ajouterPiece");
            // Vérification si post de ajouterPiece
            if (ajouterPiece != null) {
                String nomPiece = request.getParameter("nomPiece");

                // Vérification si nomPiece non null
                if (nomPiece != null) {
                    // Création
                    System.out.println("CREATION : " + user + " " + nomPiece);
                    this.pieceDao.createPiece(user, nomPiece);
                }
            }

            // Si post equipement
            String ajouterEquipement = request.getParameter("ajouterEquipement");
            // Vérification si post de ajouterPiece
            if (ajouterEquipement != null) {
                String pieceEquipement = request.getParameter("pieceEquipement");
                String nomEquipement = request.getParameter("nomEquipement");
                String typeEquipement = request.getParameter("typeEquipement");

                // Vérification formulaire
                if (pieceEquipement != null && nomEquipement != null) {
                    Equipement equipement = new Equipement(user, pieceEquipement, nomEquipement, typeEquipement, 0, true);
                    // Création
                    System.out.println("CREATION : " + user + " " + pieceEquipement + " " + nomEquipement);
                    this.equipementDao.createEquipement(equipement);
                }
            }

            // Récupération de la liste des pièces
            List<Piece> pieces = this.pieceDao.getAllPieces(user);
            session.setAttribute("userPieces", pieces);

            // Récupération de la liste des équipements
            List<Equipement> equipements = this.equipementDao.getAllEquipements(user);
            session.setAttribute("userEquipements", equipements);

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
