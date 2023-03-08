/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.User;
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
public class UserDaoImpl implements UserDao {

    private DaoFactory daoFactory;

    public UserDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void createUser(User user) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "INSERT INTO users (username, password) VALUES(?, ?);";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();

            System.out.println("INSERT INTO users " + user.getUsername());
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            Logger.getLogger(EquipementDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(EquipementDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteUser(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User readUser(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validateUser(String username, String password) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?;");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return false;
    }
}
