/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rajaonson
 */
public class DaoFactory {

    private final String url;
    private final String username;
    private final String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        String userDB = "user";
        String passDB = "user123";

        DaoFactory instance = new DaoFactory("jdbc:mysql://localhost:3306/domotique?allowPublicKeyRetrieval=true&useSSL=false", userDB, passDB);
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    public UserDao getUserDao() {
        return new UserDaoImpl(this);
    }

    public MeteoDailyDao getMeteoDailyDao() {
        return new MeteoDailyDaoImpl(this);
    }

    public MeteoHourlyDao getMeteoHourlyDao() {
        return new MeteoHourlyDaoImpl(this);
    }
    
    public PieceDao getPieceDao() {
        return new PieceDaoImpl(this);
    }
    
    public EquipementDao getEquipementDao() {
        return new EquipementDaoImpl(this);
    }
}
