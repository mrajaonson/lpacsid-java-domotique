/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.User;

/**
 *
 * @author rajaonson
 */
public interface UserDao {

    public void createUser(User user);

    public User readUser(String username);

    public void updateUser(User user);

    public void deleteUser(String username);

    public boolean validateUser(String username, String password);

}
