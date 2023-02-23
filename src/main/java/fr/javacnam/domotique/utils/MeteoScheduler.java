/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.utils;

import fr.javacnam.domotique.dao.DaoFactory;
import fr.javacnam.domotique.dao.MeteoDailyDao;
import fr.javacnam.domotique.dao.MeteoHourlyDao;
import fr.javacnam.domotique.servlets.Auth;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajaonson
 */
public class MeteoScheduler implements ServletContextListener {

    private MeteoDailyDao meteoDailyDao;
    private MeteoHourlyDao meteoHourlyDao;

    private Timer timer;
    private static final long ONE_DAY = 24 * 60 * 60 * 1000;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        DaoFactory daoFactory;
        try {
            daoFactory = DaoFactory.getInstance();
            this.meteoDailyDao = daoFactory.getMeteoDailyDao();
            this.meteoHourlyDao = daoFactory.getMeteoHourlyDao();
        } catch (SQLException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        }

        timer = new Timer();
        timer.schedule(new DailyTask(this.meteoDailyDao, this.meteoHourlyDao), getDelay(), ONE_DAY);
    }

    /**
     *
     * @param event
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        timer.cancel();
    }

    private Date getDelay() {
        // Date et heure actuelle
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,15);
        calendar.set(Calendar.MINUTE, 2);
        calendar.set(Calendar.SECOND, 0);

        // Si heure actuelle passée, passer à heure du jour suivant
        if (calendar.getTime().compareTo(new Date()) < 0) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return calendar.getTime();
    }

    private class DailyTask extends TimerTask {

        private final MeteoDailyDao meteoDailyDao1;
        private final MeteoHourlyDao meteoHourlyDao1;

        private DailyTask(MeteoDailyDao meteoDailyDao1, MeteoHourlyDao meteoHourlyDao1) {
            this.meteoDailyDao1 = meteoDailyDao1;
            this.meteoHourlyDao1 = meteoHourlyDao1;
        }

        @Override
        public void run() {
            try {
                System.out.println("Début de la récupération quotidienne de l'api météo");
                // Meteo
                Meteo meteo = new Meteo(this.meteoDailyDao1, this.meteoHourlyDao1);
                meteo.fetchMeteo();
                meteo.persistMeteo();
            } catch (ParseException | IOException ex) {
                Logger.getLogger(MeteoScheduler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
