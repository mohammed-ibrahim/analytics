package org.tools.csv.utils;

import java.util.Random;

public class Utility {

    public static String generateTag() {
        Random random = new Random();
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = alphabets.length();
        return  String.valueOf(alphabets.charAt(random.nextInt(length)))
            + String.valueOf(alphabets.charAt(random.nextInt(length)))
            + String.valueOf(System.currentTimeMillis());
    }
}
