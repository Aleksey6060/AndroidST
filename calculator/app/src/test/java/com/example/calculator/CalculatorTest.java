package com.example.calculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();
    private final double delta = 0.0001;

    @Test
    public void testAddition() {
        assertEquals(5.0, calculator.add(2.0, 3.0), delta);
        assertEquals(0.0, calculator.add(-1.0, 1.0), delta);
        assertEquals(-4.0, calculator.add(-2.0, -2.0), delta);
    }

    @Test
    public void testSubtraction() {
        assertEquals(-1.0, calculator.subtract(2.0, 3.0), delta);
        assertEquals(2.0, calculator.subtract(5.0, 3.0), delta);
        assertEquals(0.0, calculator.subtract(0.0, 0.0), delta);
    }

    @Test
    public void testMultiplication() {
        assertEquals(6.0, calculator.multiply(2.0, 3.0), delta);
        assertEquals(-6.0, calculator.multiply(-2.0, 3.0), delta);
        assertEquals(0.0, calculator.multiply(5.0, 0.0), delta);
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculator.divide(6.0, 3.0), delta);
        assertEquals(-2.0, calculator.divide(-4.0, 2.0), delta);
        assertEquals(0.5, calculator.divide(1.0, 2.0), delta);
    }
}