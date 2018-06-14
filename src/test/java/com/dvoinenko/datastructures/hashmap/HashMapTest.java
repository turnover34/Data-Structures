package com.dvoinenko.datastructures.hashmap;

import org.junit.Test;

import static org.junit.Assert.*;


    public class HashMapTest {

        HashMap hashMap = new HashMap();

        @Test
        public void testPut() {
            assertNull(hashMap.put("a", "1"));
            assertNull(hashMap.put("b", "9"));
            assertNull(hashMap.put("c", "3"));
            assertNull(hashMap.put("d", "4"));
            assertNull(hashMap.put("e", "5"));
            assertNull(hashMap.put("f", "6"));
            assertNull(hashMap.put("g", "8"));
            assertEquals("5", hashMap.put("e", "3"));
        }

        @Test
        public void testPutAll() {
            //hashMap.put(null,"1");
            hashMap.put("a","2");
            hashMap.put("b","3");
            hashMap.put("c","4");
            hashMap.put("d","5");
            hashMap.put("e","6");
            hashMap.put("f","7");
            hashMap.put("g","8");
            hashMap.put("m","9");


            HashMap hashMapSecond = new HashMap();

            hashMapSecond.put("a","2");
            //hashMapSecond.put(null,"11");
            hashMapSecond.put("m","99");
            hashMapSecond.putAll(hashMap);

           // assertEquals("1", hashMapSecond.get(null));
            assertEquals("2", hashMapSecond.get("a"));
            assertEquals("3", hashMapSecond.get("b"));
            assertEquals("4", hashMapSecond.get("c"));
            assertEquals("5", hashMapSecond.get("d"));
            assertEquals("6", hashMapSecond.get("e"));
            assertEquals("7", hashMapSecond.get("f"));
            assertEquals("8", hashMapSecond.get("g"));
            assertEquals("9", hashMapSecond.get("m"));
        }

        @Test
        public void testGet() {
            hashMap.put("a", "1");
            hashMap.put("b", "2");
            hashMap.put("c", "3");
            hashMap.put("d", "4");
            hashMap.put("e", "5");
            hashMap.put(null, "6");

            assertEquals("1", hashMap.get("a"));
            assertEquals("2", hashMap.get("b"));
            assertEquals("3", hashMap.get("c"));
            assertEquals("6", hashMap.get(null));
            assertNull(hashMap.get("aa"));
        }

        @Test
        public void testSize() {
            hashMap.put("a", "1");
            hashMap.put("b", "2");
            hashMap.put("c", "3");
            hashMap.put("d", "4");
            hashMap.put("a", "5");
            hashMap.get("ab");
            hashMap.isEmpty();
            hashMap.containsKey("ab");

            assertEquals(5, hashMap.size());

        }

        @Test
        public void testIsEmpty() {
            assertTrue(hashMap.isEmpty());
            hashMap.put("a", "1");
            assertFalse(hashMap.isEmpty());
        }

        @Test
        public void testContainsKey() {
            hashMap.put("a", "1");
            hashMap.put("b", null);
            hashMap.put("c", "3");
            hashMap.put("d", "4");
            hashMap.put("a", "5");
            assertTrue(hashMap.containsKey("a"));
            assertFalse(hashMap.containsKey("ssss"));
            assertTrue(hashMap.containsKey("b"));
        }

        @Test
        public void testPutIfAbsent() {
            hashMap.put(null,"1");
            hashMap.put("a","2");
            hashMap.put("b","3");
            hashMap.put("c","4");
            hashMap.put("d","5");
            hashMap.put("e","6");
            hashMap.put("f","7");
            hashMap.put("g","8");
            assertEquals("2",hashMap.putIfAbsent("a","3"));
            assertEquals("1",hashMap.putIfAbsent(null,"3"));
            assertNull(hashMap.putIfAbsent("aa","3"));
        }

    @Test
    public void testPutAllIfAbsent() {
        hashMap.put(null,"1");
        hashMap.put("a","2");
        hashMap.put("b","3");
        hashMap.put("c","4");
        hashMap.put("d","5");
        hashMap.put("e","6");
        hashMap.put("f","7");
        hashMap.put("g","8");
        hashMap.put("m","9");

        HashMap hashMapSecond = new HashMap();

        hashMapSecond.put("a","22");
        hashMapSecond.put(null,"11");
        hashMapSecond.put("m","99");
        hashMapSecond.putAllIfAbsent(hashMap);

        assertEquals("11", hashMapSecond.get(null));
        assertEquals("22", hashMapSecond.get("a"));
        assertEquals("3", hashMapSecond.get("b"));
        assertEquals("4", hashMapSecond.get("c"));
        assertEquals("5", hashMapSecond.get("d"));
        assertEquals("6", hashMapSecond.get("e"));
        assertEquals("7", hashMapSecond.get("f"));
        assertEquals("8", hashMapSecond.get("g"));
        assertEquals("99", hashMapSecond.get("m"));
    }

}