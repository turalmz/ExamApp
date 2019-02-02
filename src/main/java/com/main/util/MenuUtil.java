/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.util;

import com.main.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author TURAL
 */
public class MenuUtil {

    static Map<String, String> wordMapCopy;
    static Random rand = new Random();

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

    public static boolean check2(String question, int rightAnswer) {
        String ans = InputUtil.getLine(question);

        int ansNumber = 0;
        if (ans.equalsIgnoreCase("a")) {
            ansNumber = 1;
        } else if (ans.equalsIgnoreCase("b")) {
            ansNumber = 2;
        } else if (ans.equalsIgnoreCase("c")) {
            ansNumber = 3;
        } else if (ans.equalsIgnoreCase("d")) {
            ansNumber = 4;
        }
        if (rightAnswer == ansNumber) {
            System.out.println(Config.trueAnswer);
            return true;
        }
        System.out.println(Config.falseAnswer);

        return false;
    }

    public static boolean question(String en, String az) {
        int n = rand.nextInt(4) + 1;

        String vars = getVariants(n, en, az);

        if (Config.lang.equals("az")) {
            return check2(az + "-ın ingilis dilində tərcüməsi?" + "\n" + vars, n);

        } else if (Config.lang.equals("en")) {
            return check2("What is translation of " + en + " in azerbaijani?" + "\n" + vars, n);

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

    static String getVariants(int n, String en, String az) {
        String vars = "a)1,b)2,c)3,d)4";
        List anyList = null;
        if (Config.lang == "az") {
            vars = vars.replace("" + n, en);
        } else {
            vars = vars.replace("" + n, az);
        }

        if (Config.lang == "en") {
            anyList = (new ArrayList<String>(Config.askWordMap.keySet()));

        } else {

            anyList = (new ArrayList<String>(Config.askWordMap.values()));

        }

        for (int i = 1; i <= 4; i++) {
            Random rand = new Random();

            int index = rand.nextInt(Config.askWordMap.size() - 1) + 1;
            String value = (String) anyList.get(index);
            
            
            if (Config.lang == "az") {

                if (!en.equals(value)) {
                    vars = vars.replace("" + i, value);

                }else{
                    i--;
                }
                
            } else {

                if (!az.equals(value)) {
                    vars = vars.replace("" + i, value);

                }else{
                    i--;
                }

            }

        }

        return vars;
    }

}
