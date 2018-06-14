package com.dvoinenko.draft;



import com.dvoinenko.datastructures.hashmap.Map;

import java.util.ArrayList;

public class HashMap implements Map {
    private static final int DEFAULT_CAPACITY = 5;
    private final static float loadFactor = 0.75f;
    private ArrayList<Entry>[] buckets;
    private int size;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity should be over 0, but is: " + capacity);
        }
        buckets = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    @Override
    public Object put(Object key, Object value) {

        if (size >= (int) (loadFactor * buckets.length)) {
            resize();
        }

        if (key == null) {
            return putForNullKey(value);
        }

        int index = getIndex(key);
        ArrayList<Entry> bucket = buckets[index];
        Object oldValue = null;
        for (Entry entry : bucket) {
            if (entry.key != null) {
                if (key.equals(entry.key)) {
                    oldValue = entry.value;
                    entry.value = value;
                }
            }
        }
        size++;
        bucket.add(new Entry(key, value));
        return oldValue;
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
        buckets[0].add((Entry) new Entry(null, value));
        return oldValue;
    }


    private void resize() {
            int newCapacity = buckets.length*2;
            ArrayList<Entry>[] newbuckets = new ArrayList[newCapacity];
            for (int i = 0; i < newCapacity; i++) {
                newbuckets[i] = new ArrayList<>();
            }
            for (ArrayList<Entry> bucket : buckets) {
                for (Entry entry : bucket) {
                    if (entry.key == null) {
                        newbuckets[0].add(new Entry(null, entry.value));
                    }
                int index = getIndex(entry.key);
                newbuckets[index].add(new Entry(entry.key, entry.value));
                }
            }
            buckets = newbuckets;
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
        put(key, value);
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
            return getNullKey();
        }
        int index = getIndex(key);
        ArrayList<Entry> bucket = buckets[index];
            for (Entry entry : bucket) {
                if(entry.key.equals(key)) {
                    return entry.value;
                }
            }
        return null;
    }

    private Object getNullKey() {
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
            for (Entry entry : buckets[getIndex(key)]) {
                if (entry.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getIndex(Object key) {
        if (key == null || (key.hashCode() == (int) Integer.MIN_VALUE)) {
            return 0;
        }
        return Math.abs(key.hashCode()) & (buckets.length - 1);
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
