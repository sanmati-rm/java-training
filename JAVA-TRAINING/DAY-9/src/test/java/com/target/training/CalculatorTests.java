package com.target.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTests {

    Calculator calc;

    @BeforeEach
    public void setup(){
        calc= new Calculator();
    }
    
    @Test
    void shouldAddTwoNumbers(){

        Double actual = calc.add(12.,20.);
        Double expected = 32.;

        assertEquals(expected, actual);
    }

    @Test
    void shouldAddNegativeNumbers(){

        Double actual = calc.add(-10.,-20.,-30.);
        Double expected = -60.;

        assertEquals(expected, actual);
    }

    @Test
   void shouldAddAllNumbersButNulls(){
        Double actual = calc.add(10.,null,10.,null,10.1);
        Double expected = 30.1;

        assertEquals(expected, actual);
    }

    @Test
   void shouldThrowException(){
        assertThrows(NumberFormatException.class,()->calc.add(10.,"10.0","ten") );
    }

    @Test
   void shouldNotThrowException(){
        assertDoesNotThrow(()->
        {
            Double actual = calc.add(10., "10.0", "20.0");
            assertEquals(40.0, actual);
        });
    }
}
