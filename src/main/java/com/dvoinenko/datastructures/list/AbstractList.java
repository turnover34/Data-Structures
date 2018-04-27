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

    public void validateIndex(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("Index should be between 0 and size, but is" + size);
        }
    }
}
