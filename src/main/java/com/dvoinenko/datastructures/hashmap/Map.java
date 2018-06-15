package com.dvoinenko.datastructures.hashmap;

public interface Map<K, V> {

    Object put(K key, V value);

    Object get(K key);

    int size();

    boolean isEmpty();

    boolean containsKey(K key);

/*    public void putAll(HashMap map);

    public void putAllIfAbsent(HashMap map);

    public Object putIfAbsent(Object key, Object value);*/
}
