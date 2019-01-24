/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.util;

import java.util.Scanner;

/**
 *
 * @author TURAL
 */
public class InputUtil {
    public static String getLine(String text){
        System.out.println(text);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static int getNumber(String text){
        System.out.println(text);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
