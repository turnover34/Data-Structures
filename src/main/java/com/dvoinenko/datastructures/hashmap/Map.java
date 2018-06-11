package com.dvoinenko.datastructures.hashmap;

public interface Map {
    Object put(Object key, Object value);
    Object get(Object key);
    int size();
    boolean isEmpty();
    boolean containsKey(Object key);
}
