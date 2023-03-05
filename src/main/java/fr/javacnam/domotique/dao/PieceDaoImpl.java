/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.Piece;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajaonson
 */
public class PieceDaoImpl implements PieceDao {

    private final DaoFactory daoFactory;

    public PieceDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void createPiece(String utilisateur, String nom) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "INSERT INTO piece (utilisateur, nom) VALUES(?, ?);";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, utilisateur);
            preparedStatement.setString(2, nom);

            preparedStatement.executeUpdate();

            System.out.println("INSERT INTO piece " + utilisateur + " " + nom);
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            Logger.getLogger(PieceDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(PieceDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public Piece readPiece(String utilisateur, String nom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updatePiece(Piece piece) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletePiece(String utilisateur, String nom) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "DELETE FROM piece WHERE utilisateur = ? AND nom = ?;";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, utilisateur);
            preparedStatement.setString(2, nom);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("DELETE FROM piece " + utilisateur + " " + nom);
            } else {
                System.out.println("Aucun élément supprimé piece " + utilisateur + " " + nom);
            }
        } catch (SQLException e) {
            Logger.getLogger(PieceDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(PieceDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public List<Piece> getAllPieces(String utilisateur) {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            List<Piece> pieces = new ArrayList<>();
            String query = "SELECT * FROM piece WHERE utilisateur = ?;";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, utilisateur);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                System.out.println("SELECT FROM piece " + utilisateur + " " + nom);
                pieces.add(new Piece(id, utilisateur, nom));
            }
            return pieces;

        } catch (SQLException e) {
            Logger.getLogger(PieceDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(PieceDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }

}
