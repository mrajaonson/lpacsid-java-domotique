/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.MeteoHourly;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajaonson
 */
public class MeteoHourlyDaoImpl implements MeteoHourlyDao {

    private final DaoFactory daoFactory;

    public MeteoHourlyDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void createMeteoHourly(MeteoHourly meteoHourly) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "INSERT INTO meteohourly (timezone, time, temperature, precipitation) VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE temperature = ?, precipitation = ?;";
            preparedStatement = connexion.prepareStatement(query);

            // INSERT
            preparedStatement.setString(1, meteoHourly.getTimezone());
            preparedStatement.setString(2, meteoHourly.getTime());
            preparedStatement.setDouble(3, meteoHourly.getTemperature());
            preparedStatement.setDouble(4, meteoHourly.getPrecipitation());

            // UPDATE IF DUPLICATE KEY
            preparedStatement.setDouble(5, meteoHourly.getTemperature());
            preparedStatement.setDouble(6, meteoHourly.getPrecipitation());

            preparedStatement.executeUpdate();

            System.out.println("INSERT INTO meteohourly " + meteoHourly.getTimezone() + " " + meteoHourly.getTime());
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            Logger.getLogger(MeteoHourlyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(MeteoHourlyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public MeteoHourly readMeteoHourly(String timezone, String time) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM meteohourly WHERE timezone = ? AND time = ?;");

            preparedStatement.setString(1, timezone);
            preparedStatement.setString(2, time);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Double temperature = rs.getDouble("temperature");
                Double precipitation = rs.getDouble("precipitation");

                MeteoHourly meteoHourly = new MeteoHourly(timezone, time, temperature, precipitation);
                return meteoHourly;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return null;
    }

    @Override
    public void updateMeteoHourly(MeteoHourly meteoHourly) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "UPDATE meteohourly SET temperature = ?, precipitation = ? WHERE timezone = ? AND time = ?;";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setDouble(1, meteoHourly.getTemperature());
            preparedStatement.setDouble(2, meteoHourly.getPrecipitation());
            preparedStatement.setString(3, meteoHourly.getTimezone());
            preparedStatement.setString(4, meteoHourly.getTime());

            preparedStatement.executeUpdate();

            System.out.println("UPDATE meteohourly " + meteoHourly.getTimezone() + " " + meteoHourly.getTime());
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            Logger.getLogger(MeteoHourlyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(MeteoHourlyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    /**
     * Time est au format "yyyy-MM-dd'T'HH:mm" ex: "2023-02-23T00:00"
     *
     * @param timezone
     * @param time
     */
    @Override
    public void deleteMeteoHourly(String timezone, String time) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "DELETE FROM meteohourly WHERE timezone = ? AND time = ?;";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, timezone);
            preparedStatement.setString(2, time);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("DELETE FROM meteohourly " + timezone + " " + time);
            } else {
                System.out.println("Aucun élément supprimé meteohourly " + timezone + " " + time);
            }
        } catch (SQLException e) {
            Logger.getLogger(MeteoHourlyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(MeteoHourlyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public List<MeteoHourly> getDailyMeteoHourly(String timezone) {

        List<MeteoHourly> listeMeteoDaily = new ArrayList<>();

        // Récupérer la date du jour
        LocalDate now = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        for (int i = 0; i <= 23; i++) {
            String time = this.addHour(now, i);
            listeMeteoDaily.add(this.readMeteoHourly(timezone, time));
        }

        return listeMeteoDaily;
    }

    public String addHour(LocalDate localDate, int hour) {
        LocalDateTime localDateTime = localDate.atStartOfDay().plusHours(hour);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        return localDateTime.format(formatter);
    }

}
