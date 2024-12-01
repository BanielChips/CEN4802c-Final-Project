package com.cen4802c.finalProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FinalApplicationTest {

    private final JavaCalculator calculator = new JavaCalculator();

    @Test
    public void testAddition() {
        assertEquals(3, calculator.add(2, 1), "Testing addition");
    }

    @Test
    public void testSubtraction() {
        assertEquals(9, calculator.subtract(20, 11), "Testing subtraction");
    }

    @Test
    public void testMultiplication() {
        assertEquals(40, calculator.multiply(4, 10), "Testing multiplication");
    }

    @Test
    public void testDivision() {
        assertEquals(10, calculator.divide(50, 5), "Testing division");
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0), "Division by zero should throw an exception");
    }
}
