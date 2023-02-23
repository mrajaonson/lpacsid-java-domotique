/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.javacnam.domotique.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rajaonson
 */
public class Home extends HttpServlet {

    @Override
    public void init() throws ServletException {
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
        boolean isAuth = this.isAuth(session);

        if (isAuth) {
            dispatcher = contexte.getRequestDispatcher("/jsp/home.jsp");
        } else {
            dispatcher = contexte.getRequestDispatcher("/jsp/auth.jsp");
        }

        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.io.FileNotFoundException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        // Date du jour
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM HH:mm");
        String formattedDate = sdf.format(now);
        request.setAttribute("currentDate", formattedDate);
        processRequest(request, response);
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

        // Traitement déconnexion
        String action = request.getParameter("action");
        if ("deconnexion".equals(action)) {
            session.setAttribute("isAuth", null);
        }

        boolean isAuth = this.isAuth(session);

        if (isAuth) {
            dispatcher = contexte.getRequestDispatcher("/jsp/home.jsp");
        } else {
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
