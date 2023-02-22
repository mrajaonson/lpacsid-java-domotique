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

    public MeteoHourly createMeteoHourly(MeteoHourly meteoDaily);

    public MeteoHourly readMeteoHourly(String timezone, String time);

    public MeteoHourly updateMeteoHourly(MeteoHourly meteoDaily);

    public void deleteMeteoHourly(String timezone, String time);

}
