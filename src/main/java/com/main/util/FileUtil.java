/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.main.Config;
/**
 *
 * @author sarkhanrasullu
 */
public class FileUtil {
    
    static void setWordToMap(String string){
        String[] parts = string.split(",");
        String word = parts[0];
        String translation = parts[1];
        
        Config.wordMap.put(word, translation);
        Config.askWordMap.put(word, translation);

    }

    public static String read(String fileName) throws Exception {
        try (InputStream in = new FileInputStream(fileName);
                InputStreamReader r = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(r);) {
            String line = null;
            String result = "";
            while ((line = reader.readLine()) != null) {
                result += line + "\n";
                
                setWordToMap(line);
            }
            
            return result;
        }
    }

}
