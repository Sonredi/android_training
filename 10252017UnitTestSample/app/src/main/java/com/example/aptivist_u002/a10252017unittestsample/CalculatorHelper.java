package com.example.aptivist_u002.a10252017unittestsample;

/**
 * Created by Aptivist-U002 on 10/25/2017.
 */

public class CalculatorHelper {

    public static int  addition(String vale) {
        if (vale ==null){
            return Integer.MIN_VALUE;
        }
        String[] array = vale.split("\\+");
        if (array.length != 2) {
            return Integer.MIN_VALUE;
        }

        int split1;
        try {
            split1 = Integer.parseInt(array[0]);
        }catch (NumberFormatException e){
            return Integer.MIN_VALUE;
        }
        int split2;
        try {
            split2 = Integer.parseInt(array[1]);
        }catch (NumberFormatException e){
            return Integer.MIN_VALUE;
        }



        int result = split1 + split2;
        return result;
    }
}
