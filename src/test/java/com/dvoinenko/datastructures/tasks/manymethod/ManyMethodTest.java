package com.dvoinenko.datastructures.tasks.manymethod;

import org.junit.Test;

import static org.junit.Assert.*;

public class ManyMethodTest {

    ManyMethod ent = new ManyMethod();

    @Test
    public void testPrintCharArray() throws Exception {
    }

    @Test
    public void printTwoDimensionalStringArray() throws Exception {
    }

    @Test
    public void testConvertIntArrayToCharArray() throws Exception {
        int[][] array = {{65, 66, 67}, {68, 69, 70}};
        char[][] chars = {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
        assertArrayEquals(chars, ent.convertIntArrayToCharArray(array));
    }

    @Test
    public void testChangeSignIntArray() throws Exception {
        int[][] array = {{3, 4, 7}, {4, 2, 0}};
        int[][] expected = {{-3, -4, -7}, {-4, -2, 0}};
        assertArrayEquals(expected, ent.changeSignIntArray(array));
    }

    @Test
    public void testMaxOfTwo() throws Exception {
        assertEquals(-1, ent.maxOfTwo(-4, -1));
    }

    @Test
    public void testMaxOfThree() throws Exception {
        assertEquals(3, ent.maxOfThree(-1, 2, 3));
    }

    @Test
    public void testMaxOfFive() throws Exception {
        assertEquals(9, ent.maxOfFive(-3, 9, 3, 9, 7));
    }

    @Test
    public void testCharArrayToString() throws Exception {
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        assertEquals("Hello", ent.charArrayToString(chars));
    }

    @Test
    public void testSubArrayCheck() throws Exception {
        char[] mainArray = {'M', 'a', 'k', 'e', 'p', 'e', 'a', 'c', 'e'};
        char[] subArray1 = {'k', 'e', 'p', 'e'};
        char[] subArray2 = {'k', 'e', 'p', 'a'};
        assertTrue(true == ent.subArrayCheck(mainArray, subArray1));
        assertFalse(true == ent.subArrayCheck(mainArray, subArray2));


    }

    @Test
    public void testSearchIntFromBeginning() throws Exception {
        int[] array = {3, 2, 4, 2, 5, 7};
        assertEquals(1, ent.searchIntFromBeginning(array, 2));
        assertEquals(-1, ent.searchIntFromBeginning(array, 6));
    }

    @Test
    public void testSearchIntFromEnding() throws Exception {
        int[] array = {6, 5, 6, 9, 2, 6, 4, 3};
        assertEquals(5, ent.searchIntFromEnding(array, 6));
        assertEquals(-1, ent.searchIntFromEnding(array, 7));
    }

    @Test
    public void testFactorial() throws Exception {
        assertEquals(24, ent.factorial(4));
    }

    @Test
    public void testIsLeapYear() throws Exception {
        assertTrue(true == ent.isLeapYear(2004));
        assertFalse(true == ent.isLeapYear(2000));
    }

    @Test
    public void testMultiplicityCheck() throws Exception {
    }

    @Test
    public void testroundtoThirdSign() throws Exception {
        double number = 357.89164536;
        assertEquals(357.891, ent.roundtoThirdSign(number), 3);
    }

    @Test
    public void testAscOrDescOrderSort() throws Exception {
    }

    @Test
    public void testCheckForRepeatedElement() throws Exception {
        byte[] firstArray = {2, 6, 10, 3, 2};
        byte[] secondArray = {2, 3, 4, 5, 6, 7, 8};
        assertTrue( true == ent.checkForRepeatedElement(firstArray));
        assertFalse( true == ent.checkForRepeatedElement(secondArray));
    }

    @Test
    public void testSquareArrayCreator() throws Exception {
        int[] first = {1, 2, 3};
        int[] second = {4, 5, 6};
        int[][] expected = {{4, 5, 6}, {8, 10, 12}, {12, 15, 18}};
        assertArrayEquals(expected, ent.squareArrayCreator(first, second));
    }

    @Test
    public void testReverseIntArray() throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] expArray = {7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(expArray, ent.reverseIntArray(array));
    }

    @Test
    public void testRandomIntArray() throws Exception {
    }

    @Test
    public void testRandomIntArrayFull() throws Exception {
    }

    @Test
    public void testSymbolsValidation() throws Exception {
        String firstToCheck = "Hi there. - you cr@zy man." ;
        String secondToCheck = "M@n. how @re you.";
        assertTrue(true == ent.symbolsValidation(firstToCheck));
        assertFalse(true == ent.symbolsValidation(secondToCheck));
    }

    @Test
    public void testReverseTheString() throws Exception {
        String exp = "olleH";
        assertEquals("Hello", ent.reverseTheString(exp));
    }

    @Test
    public void testMergeTwoIntArrays() throws Exception {
        int[] first = {3, 5, 7};
        int[] second = {8, 2};
        int[] exp = {3, 5, 7, 8, 2};
        assertArrayEquals(exp, ent.mergeTwoIntArrays(first, second));
    }

    @Test
    public void testMaxArrayElement() throws Exception {
        int[] arrsy = {-2, 3, 5, 9, 0, 7};
        assertEquals(9, ent.maxArrayElement(arrsy));
    }
}

