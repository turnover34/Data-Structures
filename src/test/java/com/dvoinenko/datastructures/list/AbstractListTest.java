package com.dvoinenko.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractListTest {
    List emptyList;
    List listWithFiveElements;

    public abstract List getList();

    @Before
    public void before() {
        int newSize = 5;
        listWithFiveElements = getList();
        emptyList = getList();

        char symbol = 'A';
        for (int i = 0; i < newSize; i++) {
            String value = String.valueOf(symbol);
            listWithFiveElements.add(value);
            symbol++;
        }
    }

    @Test
    public void testAdd() {
        emptyList.add("A");
        emptyList.add("B");
        emptyList.add("C");
        emptyList.add("D");
        emptyList.add("E");

        assertEquals("A", emptyList.get(0));
        assertEquals("B", emptyList.get(1));
        assertEquals("C", emptyList.get(2));
        assertEquals("D", emptyList.get(3));
        assertEquals("E", emptyList.get(4));
    }

    @Test
    public void testAddByIndex() {
        emptyList.add("B", 0);
        emptyList.add("I", 1);
        emptyList.add("G", 2);

        assertEquals(3, emptyList.size());
        assertEquals("G", emptyList.get(2));
        assertEquals("B", emptyList.get(0));
    }

    @Test
    public void testRemove() {
        assertEquals(5, listWithFiveElements.size());
        assertEquals("D", listWithFiveElements.get(3));
        assertEquals("D", listWithFiveElements.remove(3));
        assertEquals("E", listWithFiveElements.get(3));
        assertEquals("B", listWithFiveElements.remove(1));
        assertEquals(3, listWithFiveElements.size());
    }

    @Test
    public void testSet() {
        listWithFiveElements.set("F", 0);
        listWithFiveElements.set("G", 1);
        listWithFiveElements.set("H", 2);
        listWithFiveElements.set("I", 3);
        listWithFiveElements.set("J", 4);

        assertEquals("H", listWithFiveElements.get(2));
        assertNotEquals("A", listWithFiveElements.get(0));
    }

    @Test
    public void testGet() {
        assertEquals("A", listWithFiveElements.get(0));
        assertEquals("C", listWithFiveElements.get(2));
        assertEquals("E", listWithFiveElements.get(4));
    }

    @Test
    public void testClear() {
        assertEquals(5, listWithFiveElements.size());
        listWithFiveElements.clear();
        assertEquals(0, listWithFiveElements.size());
        assertTrue(listWithFiveElements.size() == 0);
    }

    @Test
    public void testSize() {
        assertTrue(listWithFiveElements.size() == 5);
        assertTrue(emptyList.size() == 0);
        assertEquals(5, listWithFiveElements.size());
    }

    @Test
    public void testIsEmpty() {
        assertEquals(0, emptyList.size());
        assertTrue(emptyList.isEmpty());
        assertFalse(listWithFiveElements.isEmpty());
    }

    @Test
    public void testContains() {
        assertTrue(listWithFiveElements.contains("A"));
        assertTrue(listWithFiveElements.contains("B"));
        assertTrue(listWithFiveElements.contains("C"));
        assertTrue(listWithFiveElements.contains("D"));
        assertTrue(listWithFiveElements.contains("E"));
        assertFalse(listWithFiveElements.contains("F"));
        listWithFiveElements.add("F");
        assertTrue(listWithFiveElements.contains("F"));
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, listWithFiveElements.indexOf("A"));
        assertEquals(1, listWithFiveElements.indexOf("B"));
        assertEquals(2, listWithFiveElements.indexOf("C"));
        assertEquals(3, listWithFiveElements.indexOf("D"));
        assertEquals(4, listWithFiveElements.indexOf("E"));
        listWithFiveElements.set("A", 3);
        listWithFiveElements.set("G", 0);
        assertEquals(0, listWithFiveElements.indexOf("G"));
        assertEquals(3, listWithFiveElements.indexOf("A"));
        listWithFiveElements.add("F");
        assertEquals(5, listWithFiveElements.indexOf("F"));
    }

    @Test
    public void testLastIndexOf() {
        listWithFiveElements.set("A", 4);
        listWithFiveElements.set("A", 2);
        assertEquals(4, listWithFiveElements.lastIndexOf("A"));
        listWithFiveElements.add("A");
        assertEquals(5, listWithFiveElements.lastIndexOf("A"));
    }

}