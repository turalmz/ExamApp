/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.util;

import com.main.Config;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TURAL
 */
public class MenuUtil {

    static Map<String, String> wordMapCopy;

    public static void ask(String ob) {
        String en = wordMapCopy.get(ob);
        String az = ob;
        boolean answer = false;
        for (int i = 0; i < 3; i++) {
            answer = question(en, az);

            if (answer == true) {
                wordMapCopy.remove(ob);
                break;
            }
        }

        if (answer == false) {
            System.out.println(Config.translation(en, az));
        }
    }

    public static boolean check(String question, String rightAnswer) {
        String ans = InputUtil.getLine(question);
        if (ans.equalsIgnoreCase(rightAnswer)) {
            System.out.println(Config.trueAnswer);
            return true;
        }
        System.out.println(Config.falseAnswer);

        return false;
    }

    public static boolean question(String en, String az) {

        if (Config.lang.equals("az")) {
            return check(az + "-ın ingilis dilində tərcüməsi?", en);
        } else if (Config.lang.equals("en")) {
            return check("What is translation of " + en + " in azerbaijani?", az);
        }
        return false;
    }

    public static void proccess() throws Exception {
        selectLanguage();
        FileUtil.read("text.txt");
        while (!Config.wordMap.isEmpty()) {
            wordMapCopy = new HashMap<>(Config.wordMap);
            for (String ob : Config.wordMap.keySet()) {
                ask(ob);
            }
            Config.wordMap = wordMapCopy;
        }

        System.out.println(Config.compited);

    }

    static void selectLanguage() {
        String lang = InputUtil.getLine("Please select test language Azerbaijani/English.");

        if (lang.equalsIgnoreCase("Azerbaijani")) {
            Config.lang = "az";
            Config.trueAnswer = "Cavab düzdür!!!";
            Config.falseAnswer = "Cavab səhvdir!!!";
            Config.compited = "Proqram bitdi!!!";

        } else if (lang.equalsIgnoreCase("English")) {
            Config.lang = "en";
            Config.trueAnswer = "Right Answer!!!";
            Config.falseAnswer = "Wrong Answer!!!";
            Config.compited = "Comlited!!!";
            
        } else {
            System.out.println("Wrong input !!!");
            selectLanguage();
        }
    }

}
