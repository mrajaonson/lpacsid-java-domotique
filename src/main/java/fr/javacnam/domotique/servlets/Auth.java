/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.javacnam.domotique.servlets;

import fr.javacnam.domotique.dao.DaoFactory;
import fr.javacnam.domotique.dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajaonson
 */
public class Auth extends HttpServlet {

    private UserDao userDao;

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

        HttpSession session = request.getSession();
        ServletContext contexte = getServletContext();
        RequestDispatcher dispatcher;
        boolean isAuth = this.isAuth(session);

        if (isAuth) {
            dispatcher = contexte.getRequestDispatcher("/jsp/home.jsp");
        } else {
            dispatcher = contexte.getRequestDispatcher("/jsp/auth.jsp");
        }

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

        HttpSession session = request.getSession();
        ServletContext contexte = getServletContext();
        RequestDispatcher dispatcher;

        String username = request.getParameter("login");
        String password = request.getParameter("pass");

        // Authentifaction du user
        Boolean isAuth = (Boolean) userDao.validateUser(username, password);

        if (isAuth) {
            session.setAttribute("isAuth", isAuth);
            dispatcher = contexte.getRequestDispatcher("/jsp/home.jsp");
        } else {
            request.setAttribute("loginError", "Login et/ou mot de passe incorrect");
            dispatcher = contexte.getRequestDispatcher("/jsp/auth.jsp");
        }
        dispatcher.forward(request, response);
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

    /**
     * Vérifie si l'utilisateur a une session en cours
     *
     * @param session
     * @return
     */
    private boolean isAuth(HttpSession session) {
        return session.getAttribute("isAuth") != null ? (boolean) session.getAttribute("isAuth") : false;
    }

}
