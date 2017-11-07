package com.example.aptivist_u002.a10252017unittestsample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aptivist-U002 on 10/25/2017.
 */
public class CalculatorHelperTest {
    @Test
    public void shoulSumNumbers() throws Exception {
        assertEquals(2, CalculatorHelper.addition("1+1"));
        assertEquals(10, CalculatorHelper.addition("10+0"));
        assertNotEquals(9, CalculatorHelper.addition("5+48"));

    }

    @Test
    public void whenNotOnlyONePlusSigns_shouldReturnError() throws Exception {
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.addition("12++32"));
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.addition("1+2+"));//fail
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.addition("+"));
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.addition("+1+2+3"));

    }

    @Test
    public void whenLetterInput_shouldReturnError() throws Exception {
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.addition("12q+32"));
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.addition("hola"));
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.addition("a+1"));
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.addition("+1+2+3=r"));
    }

    @Test
    public void whenNullInput_shouldReturnError() throws Exception {
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.addition(null));
    }
}