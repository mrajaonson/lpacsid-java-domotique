/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.FileNotFoundException;
import java.text.ParseException;

import fr.javacnam.domotique.beans.MeteoDaily;
import fr.javacnam.domotique.beans.MeteoHourly;
import fr.javacnam.domotique.dao.MeteoDailyDao;
import fr.javacnam.domotique.dao.MeteoHourlyDao;

/**
 *
 * @author rajaonson
 */
public class Meteo {

    String data;

    private final MeteoDailyDao meteoDailyDao;
    private final MeteoHourlyDao meteoHourlyDao;

    public Meteo(MeteoDailyDao meteoDailyDao, MeteoHourlyDao meteoHourlyDao) {
        this.meteoDailyDao = meteoDailyDao;
        this.meteoHourlyDao = meteoHourlyDao;
    }

    public void fetchMeteo() throws IOException {
        String url = "https://api.open-meteo.com/v1/meteofrance?latitude=48.85&longitude=2.35&hourly=temperature_2m,precipitation&daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset&timezone=auto";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("fetch meteo " + responseCode);

        BufferedReader in;
        in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder responseContent = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            responseContent.append(inputLine);
        }
        in.close();
        System.out.println("fetch meteo " + responseContent);

        this.data = responseContent.toString();
    }

    public void persistMeteo() throws FileNotFoundException, ParseException {
        JsonSerializer JsonS = new JsonSerializer();

        String json = this.data;
        String timezone = JsonS.getAsStringFromJson(json, "timezone");

        // Daily
        String daily = JsonS.getStringFromJson(json, "daily");
        String[] time = JsonS.convertJsonToArray(JsonS.getStringFromJson(daily, "time"));
        String[] temperatureMax = JsonS.convertJsonToArray(JsonS.getStringFromJson(daily, "temperature_2m_max"));
        String[] temperatureMin = JsonS.convertJsonToArray(JsonS.getStringFromJson(daily, "temperature_2m_min"));
        String[] sunrise = JsonS.convertJsonToArray(JsonS.getStringFromJson(daily, "sunrise"));
        String[] sunset = JsonS.convertJsonToArray(JsonS.getStringFromJson(daily, "sunset"));

        for (int i = 0; i <= 3; i++) {
            String iTime = time[i];
            Double iTempMax = temperatureMax[i] != null ? (Double) JsonS.convertStringToDouble(temperatureMax[i]) : 0;
            Double iTempMin = temperatureMin[i] != null ? (Double) JsonS.convertStringToDouble(temperatureMin[i]) : 0;
            String iSunrise = DateFormat.formatDateHourToHour(sunrise[i]);
            String iSunset = DateFormat.formatDateHourToHour(sunset[i]);

            MeteoDaily meteoDaily = new MeteoDaily(timezone, iTime, iTempMax, iTempMin, iSunrise, iSunset);
            this.meteoDailyDao.createMeteoDaily(meteoDaily);
        }

        // Hourly
        String hourly = JsonS.getStringFromJson(json, "hourly");
        String[] hourlyTime = JsonS.convertJsonToArray(JsonS.getStringFromJson(hourly, "time"));
        String[] hourlyTemperature = JsonS.convertJsonToArray(JsonS.getStringFromJson(hourly, "temperature_2m"));
        String[] hourlyPrecipitation = JsonS.convertJsonToArray(JsonS.getStringFromJson(hourly, "precipitation"));

        for (int i = 0; i <= 95; i++) {
            String iTime = hourlyTime[i];
            Double iTemperature = hourlyTemperature[i] != null ? (Double) JsonS.convertStringToDouble(hourlyTemperature[i]) : 0;
            Double iPrecipitation = hourlyPrecipitation[i] != null ? (Double) JsonS.convertStringToDouble(hourlyPrecipitation[i]) : 0;

            MeteoHourly meteoHourly = new MeteoHourly(timezone, iTime, iTemperature, iPrecipitation);
            this.meteoHourlyDao.createMeteoHourly(meteoHourly);
        }
    }

    public MeteoDaily fetchMeteoDaily(String timezone, String time) {
        MeteoDaily meteoDaily = this.meteoDailyDao.readMeteoDaily(timezone, time);
        return meteoDaily;
    }

    public MeteoHourly fetchMeteoHourly(String timezone, String time) {
        MeteoHourly meteoHourly = this.meteoHourlyDao.readMeteoHourly(timezone, time);
        return meteoHourly;
    }

}
