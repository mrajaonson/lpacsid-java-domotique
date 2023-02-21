/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.User;
import java.util.List;

/**
 *
 * @author rajaonson
 */
public interface UserDao {

    public User createUser(User user);

    public User readUser(String username);

    public User updateUser(User user);

    public void deleteUser(String username);
    
    public boolean validateUser(String username, String password);

    public List<User> getAllUsers();
}
