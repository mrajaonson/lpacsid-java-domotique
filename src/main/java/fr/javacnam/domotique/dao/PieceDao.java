/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.Piece;
import java.util.List;

/**
 *
 * @author rajaonson
 */
public interface PieceDao {

    public void createPiece(String utilisateur, String nom);

    public Piece readPiece(String utilisateur, String nom);

    public void updatePiece(Piece piece);

    public void deletePiece(String utilisateur, String nom);

    public void deletePieceById(String id);

    public List<Piece> getAllPieces(String utilisateur);

}
