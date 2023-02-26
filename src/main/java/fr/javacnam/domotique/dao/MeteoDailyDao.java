/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.dao;

import fr.javacnam.domotique.beans.MeteoDaily;
import java.util.List;

/**
 *
 * @author rajaonson
 */
public interface MeteoDailyDao {

    public void createMeteoDaily(MeteoDaily meteoDaily);

    public MeteoDaily readMeteoDaily(String timezone, String time);

    public void updateMeteoDaily(MeteoDaily meteoDaily);

    public void deleteMeteoDaily(String timezone, String time);
    
    public MeteoDaily getCurrentMeteoDailyFromTimezone (String timezone);
    
    public List<MeteoDaily> getPrevisionMeteoDailyFromTimezone (String timezone);

}
