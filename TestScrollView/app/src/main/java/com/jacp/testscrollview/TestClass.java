package com.jacp.testscrollview;

import android.content.Intent;

/**
 * Created by Aptivist-U002 on 11/21/2017.
 */

public class TestClass {

    public static void main(String[] args) {

        String input = "i live      in san diego";
        System.out.println(toCamelCase(input));
    }

    private static String toCamelCase(String input) {
        if (input == null) {
            throw new RuntimeException("Input can't be null");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String word: input.split(" ")) {
            if (word.trim().length() > 0) {
                if (firstLetterIsValid(word.charAt(0))) {
                    stringBuilder.append(String.valueOf(word.charAt(0)).toUpperCase());
                    if (word.length() > 1) {
                        stringBuilder.append(word.substring(1, word.length()));
                    }
                } else {
                    stringBuilder.append(word);
                }
            }
        }
        return stringBuilder.toString();
    }

    private static boolean firstLetterIsValid(char ch) {
        return ch > 96 && ch < 123;
    }
}
