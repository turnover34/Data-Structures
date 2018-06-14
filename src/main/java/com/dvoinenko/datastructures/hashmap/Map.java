package com.dvoinenko.datastructures.hashmap;

public interface Map {

    Object put(Object key, Object value);

    Object get(Object key);

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

/*    public void putAll(HashMap map);

    public void putAllIfAbsent(HashMap map);

    public Object putIfAbsent(Object key, Object value);*/
}
