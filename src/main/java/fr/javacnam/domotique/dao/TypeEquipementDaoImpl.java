/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.Equipement;
import fr.javacnam.domotique.beans.TypeEquipement;
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
public class TypeEquipementDaoImpl implements TypeEquipementDao {

    private final DaoFactory daoFactory;

    public TypeEquipementDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<TypeEquipement> getAllTypeEquipement() {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            List<TypeEquipement> typesEquipement = new ArrayList<>();
            String query = "SELECT * FROM typeequipement;";
            preparedStatement = connexion.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String type = rs.getString("type");
                System.out.println("SELECT FROM equipement " + type);
                typesEquipement.add(new TypeEquipement(type));
            }
            return typesEquipement;

        } catch (SQLException e) {
            Logger.getLogger(TypeEquipementDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(TypeEquipementDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;

    }

}
