/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.MeteoDaily;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajaonson
 */
public class MeteoDailyDaoImpl implements MeteoDailyDao {

    private final DaoFactory daoFactory;

    public MeteoDailyDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void createMeteoDaily(MeteoDaily meteoDaily) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "INSERT INTO meteodaily (timezone, time, temperaturemax, temperaturemin, sunrise, sunset) VALUES(?, ?, ?, ? , ?, ?) ON DUPLICATE KEY UPDATE temperaturemax = ?, temperaturemin = ?, sunrise = ?, sunset = ?;";
            preparedStatement = connexion.prepareStatement(query);

            // INSERT
            preparedStatement.setString(1, meteoDaily.getTimezone());
            preparedStatement.setString(2, meteoDaily.getTime());
            preparedStatement.setDouble(3, meteoDaily.getTemperatureMax());
            preparedStatement.setDouble(4, meteoDaily.getTemperatureMin());
            preparedStatement.setString(5, meteoDaily.getSunrise());
            preparedStatement.setString(6, meteoDaily.getSunset());

            // UPDATE IF DUPLICATE KEY
            preparedStatement.setDouble(7, meteoDaily.getTemperatureMax());
            preparedStatement.setDouble(8, meteoDaily.getTemperatureMin());
            preparedStatement.setString(9, meteoDaily.getSunrise());
            preparedStatement.setString(10, meteoDaily.getSunset());

            preparedStatement.executeUpdate();

            System.out.println("INSERT INTO meteodaily " + meteoDaily.getTimezone() + " " + meteoDaily.getTime());
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            Logger.getLogger(MeteoDailyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(MeteoDailyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public MeteoDaily readMeteoDaily(String timezone, String time) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM meteodaily WHERE timezone = ? AND time = ?;");

            preparedStatement.setString(1, timezone);
            preparedStatement.setString(2, time);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Double tempMax = rs.getDouble("temperaturemax");
                Double tempMin = rs.getDouble("temperaturemin");
                String sunrise = rs.getString("sunrise");
                String sunset = rs.getString("sunset");

                MeteoDaily meteoDaily = new MeteoDaily(timezone, time, tempMax, tempMin, sunrise, sunset);
                return meteoDaily;
            }
        } catch (SQLException e) {
            Logger.getLogger(MeteoDailyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(MeteoDailyDaoImpl.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return null;
    }

    @Override
    public void updateMeteoDaily(MeteoDaily meteoDaily) {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "UPDATE meteodaily SET temperaturemax = ?, temperaturemin = ?, sunrise = ?, sunset = ? WHERE timezone = ? AND time = ?;";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setDouble(1, meteoDaily.getTemperatureMax());
            preparedStatement.setDouble(2, meteoDaily.getTemperatureMin());
            preparedStatement.setString(3, meteoDaily.getSunrise());
            preparedStatement.setString(4, meteoDaily.getSunset());
            preparedStatement.setString(5, meteoDaily.getTimezone());
            preparedStatement.setString(6, meteoDaily.getTime());

            preparedStatement.executeUpdate();

            System.out.println("UPDATE meteodaily " + meteoDaily.getTimezone() + " " + meteoDaily.getTime());
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            Logger.getLogger(MeteoDailyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(MeteoDailyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    @Override
    public void deleteMeteoDaily(String timezone, String time) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "DELETE FROM meteodaily WHERE timezone = ? AND time = ?;";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, timezone);
            preparedStatement.setString(2, time);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("DELETE FROM meteodaily " + timezone + " " + time);
            } else {
                System.out.println("Aucun élément supprimé meteodaily " + timezone + " " + time);
            }
        } catch (SQLException e) {
            Logger.getLogger(MeteoDailyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(MeteoDailyDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

}
