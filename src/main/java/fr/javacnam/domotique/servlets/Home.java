/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.javacnam.domotique.servlets;

import fr.javacnam.domotique.beans.Equipement;
import fr.javacnam.domotique.beans.MeteoDaily;
import fr.javacnam.domotique.beans.MeteoHourly;
import fr.javacnam.domotique.dao.DaoFactory;
import fr.javacnam.domotique.dao.EquipementDao;
import fr.javacnam.domotique.dao.MeteoDailyDao;
import fr.javacnam.domotique.dao.MeteoHourlyDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajaonson
 */
public class Home extends HttpServlet {

    // On utilise le timezone de Paris par défaut
    private final String TIMEZONE = "Europe/Paris";

    // DAO
    private MeteoDailyDao meteoDailyDao;
    private MeteoHourlyDao meteoHourlyDao;
    private EquipementDao equipementDao;

    @Override
    public void init() throws ServletException {
        DaoFactory daoFactory;
        try {
            daoFactory = DaoFactory.getInstance();
            this.meteoDailyDao = daoFactory.getMeteoDailyDao();
            this.meteoHourlyDao = daoFactory.getMeteoHourlyDao();
            this.equipementDao = daoFactory.getEquipementDao();

        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
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
            // Récupération du user connecté
            String user = (String) session.getAttribute("user");

            // Récupération données météo
            MeteoDaily meteoDaily = this.meteoDailyDao.getCurrentMeteoDailyFromTimezone(TIMEZONE);
            List<MeteoDaily> previsionMeteoDaily = this.meteoDailyDao.getPrevisionMeteoDailyFromTimezone(TIMEZONE);
            List<MeteoHourly> dailyMeteoHourly = this.meteoHourlyDao.getDailyMeteoHourly(TIMEZONE);

            // Enregistrement dans la session les données météo
            session.setAttribute("meteoDaily", meteoDaily);
            session.setAttribute("previsionMeteoDaily", previsionMeteoDaily);
            session.setAttribute("dailyMeteoHourly", dailyMeteoHourly);

            // Récupération de la liste des équipements
            List<Equipement> equipements = this.equipementDao.getAllEquipements(user);
            session.setAttribute("userEquipements", equipements);

            dispatcher = contexte.getRequestDispatcher("/jsp/home.jsp");
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
     * @throws java.io.FileNotFoundException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
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

        // Traitement déconnexion
        String action = request.getParameter("action");
        if ("deconnexion".equals(action)) {
            session.setAttribute("isAuth", null);
        }

        processRequest(request, response);
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
