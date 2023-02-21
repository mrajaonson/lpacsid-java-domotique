/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

/**
 *
 * @author rajaonson
 */
public class UserDaoImpl extends UserDao {
        private DaoFactory daoFactory;


    public UserDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
}
