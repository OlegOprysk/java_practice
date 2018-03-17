package com.java_practice.algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class QuickSortTest {

    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;



    @Before
    public void setUp() {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }


    @Test
    public void testNull() {
        QuickSort unit = new QuickSort();
        unit.sort(null);
    }


    @Test
    public void testEmpty() {
        QuickSort unit = new QuickSort();
        unit.sort(new int[0]);
    }

    @Test
    public void testSimpleElement() {
        QuickSort unit = new QuickSort();
        int[] test = new int[1];
        test[0] = 5;
        unit.sort(test);
    }

    @Test
    public void testSpecial() {
        QuickSort unit = new QuickSort();
        int[] test = {5, 7, 1, 22, 4, 12, 17, 6, 3, 23};
        unit.sort(test);
        if (!validate(test)) {
            fail("This should not happen");
        }
        printResult(test);
    }

    private void printResult(int[] test) {
        for (int i = 0; i < test.length; i++) {
            System.out.printf("%s ",test[i]);
        }
        System.out.printf("\n");
    }

    private boolean validate(int[] test) {
        for (int i = 0; i < test.length - 1; i++) {
            if (test[i] > test[i + 1]){
                return false;
            }
        }
        return true;
    }


}