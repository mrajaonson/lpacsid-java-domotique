/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author rajaonson
 */
public class JsonSerializer {

    /**
     * Retourne la valeur d'une clé d'un Json
     *
     * @param json
     * @param key
     * @return
     */
    public JsonElement getJsonElementFromJson(String json, String key) {
        JsonElement jsonElement = JsonParser.parseString(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        return jsonObject.get(key);
    }

    /**
     * Retourne sous forme de String la valeur d'une clé d'un Json. La valeur
     * est une chaîne de caractères
     *
     * @param json
     * @param key
     * @return
     */
    public String getAsStringFromJson(String json, String key) {
        JsonElement value = this.getJsonElementFromJson(json, key);
        return value != null ? value.getAsString() : "";
    }

    /**
     * Retourne sous forme de String la valeur d'une clé d'un Json. La valeur
     * est un autre objet json
     *
     * @param json
     * @param key
     * @return
     */
    public String getStringFromJson(String json, String key) {
        JsonElement value = this.getJsonElementFromJson(json, key);
        return value != null ? value.toString() : "";
    }

    /**
     * Transforme un json en un array String[]
     *
     * @param json
     * @return
     */
    public String[] convertJsonToArray(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, String[].class);
    }

    public Number convertStringToDouble(String string) {
        return Double.valueOf(string);
    }

}
