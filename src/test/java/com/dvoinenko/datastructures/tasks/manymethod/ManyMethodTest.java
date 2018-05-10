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
    public void testConvert() throws Exception {
        int[][] array = {{65, 66, 67}, {68, 69, 70}};
        char[][] chars = {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
        assertArrayEquals(chars, ent.convert(array));
    }

    @Test
    public void testChangeSign() throws Exception {
        int[][] array = {{3, 4, 7}, {4, 2, 0}};
        int[][] expected = {{-3, -4, -7}, {-4, -2, 0}};
        assertArrayEquals(expected, ent.changeSign(array));
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
    public void testToString() throws Exception {
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        assertEquals("Hello", ent.toString(chars));
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
    public void testSearchFromBeginning() throws Exception {
        int[] array = {3, 2, 4, 2, 5, 7};
        assertEquals(1, ent.searchFromBeginning(array, 2));
        assertEquals(-1, ent.searchFromBeginning(array, 6));
    }

    @Test
    public void testSearchFromEnding() throws Exception {
        int[] array = {6, 5, 6, 9, 2, 6, 4, 3};
        assertEquals(5, ent.searchFromEnding(array, 6));
        assertEquals(-1, ent.searchFromEnding(array, 7));
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
        assertEquals(357.891, ent.round(number), 3);
    }

    @Test
    public void testAscOrDescOrderSort() throws Exception {
        int[] array = {4, 2, 7, 10, 11, 0, -2, 5};
        int[] ascArray = {-2, 0, 2, 4, 5, 7, 10, 11};
        int[] desArray = {11, 10, 7, 5, 4, 2, 0, -2};
        assertArrayEquals(ascArray, ent.acsSort(array));
        assertArrayEquals(ascArray, ent.ascOrDescSort(array,false));
        assertArrayEquals(desArray, ent.descSort(array));
        assertArrayEquals(desArray, ent.ascOrDescSort(array, true));
    }

    @Test
    public void testCheckForRepeatedElement() throws Exception {
        byte[] firstArray = {2, 6, 10, 3, 2};
        byte[] secondArray = {2, 3, 4, 5, 6, 7, 8};
        assertTrue( true == ent.check(firstArray));
        assertFalse( true == ent.check(secondArray));
    }

    @Test
    public void testCreate() throws Exception {
        int[] first = {1, 2, 3};
        int[] second = {4, 5, 6};
        int[] expected = {4, 10, 18};
        assertArrayEquals(expected, ent.create(first, second));
    }

    @Test
    public void testReverse() throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] expArray = {7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(expArray, ent.reverse(array));
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
    public void TestReverse() throws Exception {
        String exp = "olleH";
        assertEquals("Hello", ent.reverse(exp));
    }

    @Test
    public void testMerge() throws Exception {
        int[] first = {3, 5, 7};
        int[] second = {8, 2};
        int[] exp = {3, 5, 7, 8, 2};
        assertArrayEquals(exp, ent.merge(first, second));
    }

    @Test
    public void testMaxElement() throws Exception {
        int[] arrsy = {-2, 3, 5, 9, 0, 7};
        assertEquals(9, ent.maxElement(arrsy));
    }
}

