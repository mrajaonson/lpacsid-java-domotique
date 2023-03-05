/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.Equipement;
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
public class EquipementDaoImpl implements EquipementDao {

    private final DaoFactory daoFactory;

    public EquipementDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void createEquipement(Equipement equipement) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "INSERT INTO equipement VALUES(?, ?, ?, ?, ?, ?);";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, equipement.getUtilisateur());
            preparedStatement.setString(2, equipement.getPiece());
            preparedStatement.setString(3, equipement.getNom());
            preparedStatement.setString(4, equipement.getType());
            preparedStatement.setInt(5, equipement.getValeur());
            preparedStatement.setBoolean(6, equipement.isConnected());

            preparedStatement.executeUpdate();

            System.out.println("INSERT INTO equipement " + equipement.getUtilisateur() + " " + equipement.getPiece() + " " + equipement.getNom());
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
    public Equipement readEquipement(String utilisateur, String piece, String nom) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM equipement WHERE utilisateur = ? AND piece = ? AND nom = ?;");

            preparedStatement.setString(1, utilisateur);
            preparedStatement.setString(2, piece);
            preparedStatement.setString(2, nom);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                Integer valeur = rs.getInt("valeur");
                Boolean estConnecte = rs.getBoolean("estConnecte");

                Equipement equipement = new Equipement(id, utilisateur, piece, nom, type, valeur, estConnecte);
                System.out.println("readEquipement : " + utilisateur + " " + piece + " " + nom);
                return equipement;
            }
        } catch (SQLException e) {
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
        return null;
    }

    @Override
    public void updateEquipement(Equipement equipement) {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "UPDATE equipement SET valeur = ?, estConnecte = ? WHERE utilisateur = ? AND piece = ? AND nom = ?;";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setInt(1, equipement.getValeur());
            preparedStatement.setBoolean(2, equipement.isConnected());
            preparedStatement.setString(3, equipement.getUtilisateur());
            preparedStatement.setString(4, equipement.getPiece());
            preparedStatement.setString(5, equipement.getNom());

            preparedStatement.executeUpdate();

            System.out.println("UPDATE equipement " + equipement.getUtilisateur() + " " + equipement.getPiece() + " " + equipement.getNom());
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
    public void deleteEquipement(String utilisateur, String piece, String nom) {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            String query = "DELETE FROM equipement WHERE utilisateur = ? AND piece = ? AND nom = ?;";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, utilisateur);
            preparedStatement.setString(2, piece);
            preparedStatement.setString(3, nom);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("DELETE FROM equipement " + utilisateur + " " + piece + " " + nom);
            } else {
                System.out.println("Aucun élément supprimé equipement " + utilisateur + " " + piece + " " + nom);
            }
        } catch (SQLException e) {
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
    public List<Equipement> getAllEquipements(String utilisateur) {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            List<Equipement> equipements = new ArrayList<>();
            String query = "SELECT * FROM equipement WHERE utilisateur = ?;";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, utilisateur);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String piece = rs.getString("piece");
                String nom = rs.getString("nom");
                String type = rs.getString("type");
                Integer valeur = rs.getInt("valeur");
                Boolean estConnecte = rs.getBoolean("estConnecte");
                System.out.println("SELECT FROM equipement " + utilisateur + " " + nom);
                equipements.add(new Equipement(id, utilisateur, piece, nom, type, valeur, estConnecte));
            }
            return equipements;

        } catch (SQLException e) {
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
        return null;
    }

    @Override
    public List<Equipement> getAllEquipementsPiece(String utilisateur, String piece) {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            List<Equipement> equipements = new ArrayList<>();
            String query = "SELECT * FROM equipement WHERE utilisateur = ? AND piece = ?;";
            preparedStatement = connexion.prepareStatement(query);

            preparedStatement.setString(1, utilisateur);
            preparedStatement.setString(1, piece);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String type = rs.getString("type");
                Integer valeur = rs.getInt("valeur");
                Boolean estConnecte = rs.getBoolean("estConnecte");
                System.out.println("SELECT FROM equipement " + utilisateur + " " + nom);
                equipements.add(new Equipement(id, utilisateur, piece, nom, type, valeur, estConnecte));
            }
            return equipements;

        } catch (SQLException e) {
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
        return null;

    }

}
