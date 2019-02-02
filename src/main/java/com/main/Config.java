package com.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TURAL
 */
public class Config {

    public static Map<String, String> wordMap = new HashMap<String, String>();
    public static Map<String, String> askWordMap = new HashMap<String, String>();

    public static String lang = "en";
    public static String trueAnswer = "Right Answer!!!";
    public static String falseAnswer = "Wrong Answer!!!";
    public static String compited = "Comlited!!!";

    public static String translation(String en, String az) {
        if (lang.equals("en")) {
            return "Translation of " + en + " is " + az;

        } else {
            return az + "-in tərcüməsi " + en + "-dır";
        }
    }
    
}
