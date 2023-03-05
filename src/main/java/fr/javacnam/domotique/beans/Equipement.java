/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.beans;

/**
 *
 * @author rajaonson
 */
public class Equipement {

    private String id;
    private String utilisateur;
    private String piece;
    private String nom;
    private String type;
    private Integer valeur;
    private Boolean estConnecte;

    public Equipement(int id, String utilisateur, String piece, String nom, String type, Integer valeur, Boolean estConnecte) {
        this.id = "E" + id;
        this.utilisateur = utilisateur;
        this.piece = piece;
        this.nom = nom;
        this.type = type;
        this.valeur = valeur;
        this.estConnecte = estConnecte;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = "E" + id;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    public Boolean isConnected() {
        return estConnecte;
    }

    public void setConnected(Boolean estConnecte) {
        this.estConnecte = estConnecte;
    }

}
