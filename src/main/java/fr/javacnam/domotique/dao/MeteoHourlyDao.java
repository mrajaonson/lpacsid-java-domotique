/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.MeteoHourly;

/**
 *
 * @author rajaonson
 */
public interface MeteoHourlyDao {

    public void createMeteoHourly(MeteoHourly meteoDaily);

    public MeteoHourly readMeteoHourly(String timezone, String time);

    public void updateMeteoHourly(MeteoHourly meteoDaily);

    public void deleteMeteoHourly(String timezone, String time);

}
