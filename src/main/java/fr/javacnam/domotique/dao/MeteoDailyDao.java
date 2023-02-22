/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.MeteoDaily;

/**
 *
 * @author rajaonson
 */
public interface MeteoDailyDao {

    public MeteoDaily createMeteoDaily(MeteoDaily meteoDaily);

    public MeteoDaily readMeteoDaily(String timezone, String time);

    public MeteoDaily updateMeteoDaily(MeteoDaily meteoDaily);

    public void deleteMeteoDaily(String timezone, String time);

}
