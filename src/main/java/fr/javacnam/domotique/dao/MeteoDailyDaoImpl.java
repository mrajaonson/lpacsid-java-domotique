/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.MeteoDaily;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajaonson
 */
public class MeteoDailyDaoImpl implements MeteoDailyDao {

    private final DaoFactory daoFactory;
    private static final String TABLE = "meteodaily";

    public MeteoDailyDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public MeteoDaily createMeteoDaily(MeteoDaily meteoDaily) {
        try {
            Connection connexion = null;
            PreparedStatement preparedStatement = null;

            connexion = daoFactory.getConnection();
            String query = "INSERT INTO meteodaily VALUES(?, ?, ?, ? , ?, ?);";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, meteoDaily.getTimezone());
            preparedStatement.setString(2, meteoDaily.getTime());
            preparedStatement.setDouble(3, (double) meteoDaily.getTemperatureMax());
            preparedStatement.setDouble(4, (double) meteoDaily.getTemperatureMin());
            preparedStatement.setString(5, meteoDaily.getSunrise());
            preparedStatement.setString(6, meteoDaily.getSunset());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("INSERT " + TABLE + " " + meteoDaily.getTime());
                return meteoDaily;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MeteoDailyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public MeteoDaily readMeteoDaily(String timezone, String time) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MeteoDaily updateMeteoDaily(MeteoDaily meteoDaily) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteMeteoDaily(String timezone, String time) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
