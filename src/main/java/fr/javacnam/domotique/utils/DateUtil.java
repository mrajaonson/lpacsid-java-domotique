/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.javacnam.domotique.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rajaonson
 */
public class DateUtil {

    public static String getCurrentTime() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM HH:mm");
        return sdf.format(now);
    }

}
