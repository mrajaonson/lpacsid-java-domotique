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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
        String json = this.data;
        String timezone = this.getJsonObject(json, "timezone");

        // Daily
        String daily = this.getJsonObject(json, "daily");
        String[] time = this.convertJsonToArray(this.getJsonObject(daily, "time"));
        String[] temperatureMax = this.convertJsonToArray(this.getJsonObject(daily, "temperature_2m_max"));
        String[] temperatureMin = this.convertJsonToArray(this.getJsonObject(daily, "temperature_2m_min"));
        String[] sunrise = this.convertJsonToArray(this.getJsonObject(daily, "sunrise"));
        String[] sunset = this.convertJsonToArray(this.getJsonObject(daily, "sunset"));

        for (int i = 0; i <= 3; i++) {
            String iTime = time[i];
            Double iTempMax = (Double) this.convertStringToDouble(temperatureMax[i]);
            Double iTempMin = (Double) this.convertStringToDouble(temperatureMin[i]);
            String iSunrise = sunrise[i];
            String iSunset = sunset[i];

            MeteoDaily meteoDaily = new MeteoDaily(timezone, iTime, iTempMax, iTempMin, iSunrise, iSunset);
            this.meteoDailyDao.createMeteoDaily(meteoDaily);
        }

        // Hourly
        String hourly = this.getJsonObject(json, "hourly");
        String[] hourlyTime = this.convertJsonToArray(this.getJsonObject(hourly, "time"));
        String[] hourlyTemperature = this.convertJsonToArray(this.getJsonObject(hourly, "temperature_2m"));
        String[] hourlyPrecipitation = this.convertJsonToArray(this.getJsonObject(hourly, "precipitation"));

        for (int i = 0; i <= 95; i++) {
            String iTime = hourlyTime[i];
            Double iTemperature = (Double) this.convertStringToDouble(hourlyTemperature[i]);
            Double iPrecipitation = (Double) this.convertStringToDouble(hourlyPrecipitation[i]);

            MeteoHourly meteoHourly = new MeteoHourly(timezone, iTime, iTemperature, iPrecipitation);
            this.meteoHourlyDao.createMeteoHourly(meteoHourly);
        }

    }

    public String getJsonObject(String json, String key) {
        JsonElement jsonElement = JsonParser.parseString(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonElement value = jsonObject.get(key);

        return value != null ? value.toString() : "";

    }

    public Number convertStringToDouble(String string) {
        return Double.valueOf(string);
    }

    public String[] convertJsonToArray(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, String[].class);
    }

}
