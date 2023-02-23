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

    public void createEquipement(String utilisateur, String nom);

    public Equipement readEquipement(String utilisateur, String nom);

    public void updateEquipement(Equipement piece);

    public void deleteEquipement(String utilisateur, String nom);

    public List<Equipement> getAllEquipements(String utilisateur);

}
