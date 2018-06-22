package com.dvoinenko.datastructures.hashmap;


import java.util.ArrayList;
import java.util.Iterator;

public class HashMap<K, V> implements Map<K, V>, Iterable<HashMap.Entry<K, V>> {
    private static final int DEFAULT_CAPACITY = 5;
    private static final double LOAD_FACTOR = 0.75d;
    private int size;
    ArrayList<Entry<K, V>>[] buckets;

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
    public Object put(K key, V value) {
        ArrayList<Entry<K, V>>[] buckets = this.buckets;

        if (size >= LOAD_FACTOR*buckets.length) {
            resize();
        }
        if (key == null) {
            putForNullKey(value);
        }

        int index = indexFor(key, buckets.length);

        Object oldValue = null;
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key != null) {
                if (key.equals(entry.key)) {
                    oldValue = entry.value;
                    entry.value = value;
                    return oldValue;
                }
            }
        }
        size++;
        buckets[index].add(new Entry<>(key, value));
        return oldValue;
    }

    private int indexFor(K key, int bucketsCount) {
        if (key == null) {
            return 0;
        }
        int hashed = key.hashCode();
        hashed ^= (hashed >>> 20) ^ (hashed >>> 12);
        hashed ^= (hashed >>> 7) ^ (hashed >>> 4);
        return hashed & (bucketsCount - 1);
    }

    private void resize() {
        int newCapacity = buckets.length*2;
        ArrayList<Entry<K, V>>[] newBuckets = new ArrayList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newBuckets[i] = new ArrayList<>(1);
        }
        transfer(newBuckets);
        buckets = newBuckets;
    }

    private void transfer(ArrayList<Entry<K, V>>[] newBuckets) {
        for (ArrayList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                K key = entry.key;
                int bucketsCount = newBuckets.length;
                int index = indexFor(key, bucketsCount);
                newBuckets[index].add(entry);
            }
        }
    }

    private Object putForNullKey(V value) {
        V oldValue = null;
        for (Entry<K, V> entry : buckets[0]) {
            if (entry.key == null) {
                oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        buckets[0].add( new Entry<K, V>(null, value));
        size++;
        return oldValue;
    }
    
    public void putAll(HashMap<K, V> hashMap) {
        for (ArrayList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                hashMap.put(entry.key, entry.value);
            }
        }
    }

    public Object putIfAbsent(K key, V value) {
       if (containsKey(key)) {
           return get(key);
       } else{
           put(key, value);
       }
       return null;
    }

    public void putAllIfAbsent(HashMap<K, V> hashMap) {
        for (ArrayList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                putIfAbsent(entry.key, entry.value);
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return getForNull();
        }

        int index = indexFor(key, buckets.length);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key != null) {
                if (key.equals(entry.key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    private V getForNull() {
        for (Entry<K, V> entry : buckets[0]) {
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
    public boolean containsKey(K key) {
        if (key == null) {
            for (Entry<K, V> entry : buckets[0]) {
                if (entry.key == null) {
                    return true;
                }
            }
        } else {
            int index = indexFor(key, buckets.length);
            for (Entry<K, V> entry : buckets[index]) {
                if (key.equals(entry.key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new MyIterator();
    }

    class MyIterator<E> implements Iterator<Entry> {
        private int bucketIndex;
        private Iterator<Entry<K, V>> bucketIterator;
        private int passedElementsCount;

        @Override
        public boolean hasNext() {
            return passedElementsCount < size;
        }

        @Override
        public Entry<K, V> next() {
            for (int i = 0; i < buckets.length; i++) {
                 ArrayList<Entry<K, V>> bucket = buckets[bucketIndex];
                bucketIterator = bucket.iterator();
                while (bucketIterator.hasNext()) {
                    passedElementsCount++;
                    return bucketIterator.next();
                }
                bucketIndex++;
            }
            passedElementsCount++;
            return null;
        }
    }

    public static class Entry<K, V>  {
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }


        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
