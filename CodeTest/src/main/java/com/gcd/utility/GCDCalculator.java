package com.gcd.utility;


public class GCDCalculator {

    public static int calculateGCD(int value1, int value2) {
        return findGCD(value1,value2);
    }

    private static int findGCD(int value1, int value2) {
        if (value2 == 0) {
            return value1;
        }
        return findGCD(value2, value1 % value2);
    }

}
