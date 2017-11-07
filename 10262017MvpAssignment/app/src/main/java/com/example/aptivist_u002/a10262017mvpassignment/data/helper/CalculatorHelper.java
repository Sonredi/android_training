package com.example.aptivist_u002.a10262017mvpassignment.data.helper;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */

public class CalculatorHelper {

    public int subtraction(String value) {
        if (value != null) {
            int counter = 0;
            for( int i=0; i<value.length(); i++ ) {
                if( value.charAt(i) == '-' ) counter++;
            }
            if (counter !=1) return Integer.MAX_VALUE;
            String[] elements = value.split("-");
            if (elements.length == 2) {
                try {
                    return Integer.parseInt(elements[0]) - Integer.parseInt(elements[1]);
                } catch (NumberFormatException e) {
                    return Integer.MAX_VALUE;
                }
            } else {
                return Integer.MAX_VALUE;
            }
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public Double multiplication(String value) {
        if (value != null) {
            int counter = 0;
            for( int i=0; i<value.length(); i++ ) {
                if( value.charAt(i) == '*' ) counter++;
            }
            if (counter !=1) return null;
            String[] elements = value.split("\\*");
            if (elements.length == 2) {
                try {
                    return Double.parseDouble(elements[0]) * Double.parseDouble(elements[1]);
                } catch (NumberFormatException e) {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
