/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.beans;

/**
 *
 * @author rajaonson
 */
public class MeteoHourly {

    private String timezone;
    private String time;
    private Double temperature;
    private Double precipitation;

    public MeteoHourly(String timezone, String time, Double temperature, Double precipitation) {
        this.timezone = timezone;
        this.time = time;
        this.temperature = temperature;
        this.precipitation = precipitation;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Number getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Number getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

}
