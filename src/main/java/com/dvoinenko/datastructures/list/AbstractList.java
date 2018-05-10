package com.dvoinenko.datastructures.list;

public abstract class AbstractList implements List{
    int size;

    public void add(Object value) {
        add(value, size);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index should be between 0 inclusive" +
                    " and " + size + " exclusive, but is " + index);
        }
    }

    void validateIndexToAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between 0 inclusive "
                    + "and " + size + " inclusive, but is " + index);
        }
    }
}
