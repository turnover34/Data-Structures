package com.dvoinenko.datastructures.hashmap;


import java.util.ArrayList;

public class HashMap implements Map {
    private static final int DEFAULT_CAPACITY = 5;
    private static final double LOAD_FACTOR = 0.75d;
    private int size;
    ArrayList<Entry>[] buckets;


    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int capacity) {
        buckets = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new ArrayList<>();
        }
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Object put(Object key, Object value) {
        if (size >= (int) (LOAD_FACTOR*buckets.length)) {
            resize();
        }
        if (key == null) {
            putForNullKey(value);
        }

        int index = indexFor(key, buckets);

        Object oldValue = null;
        for (Entry entry : buckets[index]) {
            if (entry.key != null) {
                if (key.equals(entry.key)) {
                    oldValue = entry.value;
                    entry.value = value;
                }
            }
        }
        buckets[index].add(new Entry(key, value));
        size++;
        return oldValue;
    }

    private int indexFor(Object key, ArrayList<Entry>[] buckets) {
        if (key == null) {
            return 0;
        }
        int hashed = key.hashCode();
        hashed ^= (hashed >>> 20) ^ (hashed >>> 12);
        hashed ^= (hashed >>> 7) ^ (hashed >>> 4);
        return hashed & (buckets.length - 1);
    }



    private void resize() {
        int newCapacity = buckets.length*2;
        ArrayList<Entry>[] newBuckets = new ArrayList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newBuckets[i] = new ArrayList<>();
        }
        transfer(newBuckets);
        buckets = newBuckets;
    }

    private void transfer(ArrayList<Entry>[] newBuckets) {
        for (ArrayList<Entry> bucket : buckets) {
            for (Entry entry : bucket) {
                if (entry.key == null) {
                    newBuckets[0].add(new Entry(null, entry.value));
                } else {
                    int index = indexFor(entry.key, newBuckets);
                    newBuckets[index].add(new Entry(entry.key, entry.value));
                }
            }
        }
    }

    private Object putForNullKey(Object value) {
        Object oldValue = null;
        for (Entry entry : buckets[0]) {
            if (entry.key == null) {
                oldValue = entry.value;
                entry.value = value;
            }
        }
        size++;
        buckets[0].add( new Entry(null, value));
        return oldValue;
    }
    
    public void putAll(HashMap hashMap) {
        for (ArrayList<Entry> bucket : buckets) {
            for (Entry entry : bucket) {
                hashMap.put(entry.key, entry.value);
            }
        }
    }

    public Object putIfAbsent(Object key, Object value) {
       if (containsKey(key)) {
           return get(key);
       }
       else put(key, value);
       return null;
    }

    public void putAllIfAbsent(HashMap hashMap) {
        for (ArrayList<Entry> bucket : buckets) {
            for (Entry entry : bucket) {
                putIfAbsent(entry.key, entry.value);
            }
        }
    }

    @Override
    public Object get(Object key) {
        if (key == null) {
            return getForNull();
        }
        int index = indexFor(key, buckets);
        for (Entry entry : buckets[index]) {
            if (entry.key != null) {
                if (key.equals(entry.key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    private Object getForNull() {
        for (Entry entry : buckets[0]) {
            if (entry.key == null) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            for (Entry entry : buckets[0]) {
                if (entry.key == null) {
                    return true;
                }
            }
        } else {
            for (Entry entry : buckets[indexFor(key, buckets)]) {
                if (entry.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class Entry  {
        private Object key;
        private Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
