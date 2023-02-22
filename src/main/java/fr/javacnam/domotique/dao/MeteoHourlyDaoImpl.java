/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.MeteoHourly;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public MeteoHourly createMeteoHourly(MeteoHourly meteoHourly) {
        try {
            Connection connexion = null;
            PreparedStatement preparedStatement = null;

            connexion = daoFactory.getConnection();
            String query = "INSERT INTO meteohourly VALUES(?, ?, ?, ?);";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, meteoHourly.getTimezone());
            preparedStatement.setString(2, meteoHourly.getTime());
            preparedStatement.setDouble(3, (double) meteoHourly.getTemperature());
            preparedStatement.setDouble(4, (double) meteoHourly.getPrecipitation());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("INSERT " + meteoHourly.getTime());
                return meteoHourly;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MeteoHourlyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public MeteoHourly readMeteoHourly(String timezone, String time) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MeteoHourly updateMeteoHourly(MeteoHourly meteoDaily) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteMeteoHourly(String timezone, String time) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
