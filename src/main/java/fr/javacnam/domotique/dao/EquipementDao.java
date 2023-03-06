/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.Equipement;
import java.util.List;

/**
 *
 * @author rajaonson
 */
public interface EquipementDao {

    public void createEquipement(Equipement equipement);

    public Equipement readEquipement(String utilisateur, String piece, String nom);

    public Equipement readEquipementById(String localId);

    public void updateEquipement(Equipement equipement);

    public void deleteEquipement(String utilisateur, String piece, String nom);

    public void deleteEquipementById(String localId);

    public List<Equipement> getAllEquipements(String utilisateur);

    public List<Equipement> getAllEquipementsPiece(String utilisateur, String piece);

}
