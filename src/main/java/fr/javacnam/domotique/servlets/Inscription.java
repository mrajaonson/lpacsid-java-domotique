/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.javacnam.domotique.servlets;

import fr.javacnam.domotique.beans.User;
import fr.javacnam.domotique.dao.DaoFactory;
import fr.javacnam.domotique.dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajaonson
 */
public class Inscription extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        DaoFactory daoFactory;
        try {
            daoFactory = DaoFactory.getInstance();
            this.userDao = daoFactory.getUserDao();
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
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
        ServletContext contexte = getServletContext();
        RequestDispatcher dispatcher;

        String inscription = request.getParameter("inscription");
        if (inscription != null) {
            String username = request.getParameter("login");
            String password = request.getParameter("pass");

            User utilisateur = new User(username, password);
            this.userDao.createUser(utilisateur);
        }

        dispatcher = contexte.getRequestDispatcher("/jsp/inscription.jsp");
        dispatcher.forward(request, response);
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

        dispatcher = contexte.getRequestDispatcher("/jsp/inscription.jsp");
        dispatcher.forward(request, response);
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
        String inscription = request.getParameter("inscription");
        if (inscription != null) {
            String username = request.getParameter("login");
            String password = request.getParameter("pass");

            User utilisateur = new User(username, password);
            this.userDao.createUser(utilisateur);
        }

        response.sendRedirect("Auth");
    }

}
