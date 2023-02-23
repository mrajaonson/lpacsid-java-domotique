/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author rajaonson
 */
public class DateFormat {

    /**
     * Transforme une date string en "HH'h'mm"
     *
     * @param input
     * @return
     */
    public static String formatDateHourToHour(String input) {
        LocalDateTime dateTime = LocalDateTime.parse(input);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        return dateTime.format(formatter);
    }

}
