package com.example.aptivist_u002.a10262017mvpassignment;

import com.example.aptivist_u002.a10262017mvpassignment.data.helper.CalculatorHelper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aptivist-U002 on 10/26/2017.
 */

public class CalculatorHelperTest {

    @Test
    public void whenOnlyNumbersAndOneMinusSign_shouldSubtract() throws Exception {
        assertEquals(3, CalculatorHelper.subtraction("10-7"));
    }

    @Test
    public void whenNotNumbers_shouldReturnError() throws Exception {
        assertEquals(Integer.MAX_VALUE, CalculatorHelper.subtraction("a-b"));
    }

    @Test
    public void whenNoMinusSign_shouldReturnError() throws Exception {
        assertEquals(Integer.MAX_VALUE, CalculatorHelper.subtraction("4567"));
    }

    @Test
    public void whenMoreThanOneMinusSign_shouldReturnError() throws Exception {
        assertEquals(Integer.MAX_VALUE, CalculatorHelper.subtraction("12-123-3"));
        assertEquals(Integer.MAX_VALUE, CalculatorHelper.subtraction("12-123-"));
    }

    @Test
    public void whenNullInput_shouldReturnError() throws Exception {
        assertEquals(Integer.MAX_VALUE, CalculatorHelper.subtraction(null));
    }


    @Test
    public void whenTwoNumbers_shouldMultiply() throws Exception {
        assertEquals(new Double(25), CalculatorHelper.multiplication("5*5"));
    }

    @Test
    public void whenNoNumbers_shouldReturnNull() throws Exception {
        assertEquals(null, CalculatorHelper.multiplication("a*b"));
    }

    @Test
    public void whenNoSign_shouldReturnNull() throws Exception {
        assertEquals(null, CalculatorHelper.multiplication("ab"));
    }

    @Test
    public void whenMoreThanOneSign_shouldReturnNull() throws Exception {
        assertEquals(null, CalculatorHelper.multiplication("3*4*"));
    }

    @Test
    public void whenNullInput_shouldReturnNull() throws Exception {
        assertEquals(null, CalculatorHelper.multiplication(null));
    }

}
