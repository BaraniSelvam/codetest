package com.gcd.utility;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



public class GCDCalculatorTest {

    @Test
    public void calculateGCD() throws Exception {

        assertThat(GCDCalculator.calculateGCD(20,16), is(4));
    }

}