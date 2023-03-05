/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.beans;

/**
 *
 * @author rajaonson
 */
public class Piece {

    private String id;
    private String utilisateur;
    private String nom;

    public Piece(int id, String utilisateur, String nom) {
        this.id = "P" + id;
        this.utilisateur = utilisateur;
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = "P" + id;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
