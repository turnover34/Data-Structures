package com.dvoinenko.datastructures.hashmap;

import java.util.ArrayList;

public class HashMap implements Map {
    private static final int DEFAULT_CAPACITY = 5;
    private ArrayList<Entry>[] buckets;
    private int size;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int bucketsLength) {
        buckets = new ArrayList [bucketsLength];
        for (int i = 0; i < bucketsLength; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    @Override
    public Object put(Object key, Object value) {
        boolean updated = false;
        Object oldValue = null;
        validate(key);
        int index = hash(key);

        for (Entry entry : buckets[index]) {
            if(entry.key.equals(key)) {
                oldValue = entry.value;
                entry.value = value;
                updated = true;
            }
        }

        if(!updated) {
            buckets[index].add(new Entry(key, value));
            size++;
            return null;
        }
        return oldValue;
    }

    @Override
    public Object get(Object key) {
        validate(key);
        int index = hash(key);

        for (Entry entry : buckets[index]) {
            if(entry.key.equals(key)) {
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
        return get(key) != null;
    }

    public void validate(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("key doesn't exist");
        }
    }

    private int hash(Object key) {
        return key.hashCode() % buckets.length;
    }


    private static class Entry {
        private Object key;
        private Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
