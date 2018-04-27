package com.dvoinenko.datastructures.stack;

import java.util.NoSuchElementException;

public class ArrayStack extends AbstractStack {
    private final static int INITIAL_CAPACITY = 5;
    private int capacity;
    private Object[] stack;

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new Object[capacity];
    }

    public void push(Object value) {
        if (isFull()) {
            resize();
        }
        stack[size++] = value;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty ");
        }
        return stack[size - 1];
    }

    public Object pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty ");
        }
        Object toRemove = stack[size - 1];
        System.arraycopy(stack, 0, stack, 0, size - 1);
        size--;
        return toRemove;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public  boolean isFull() {
        return size == capacity;
    }

    public void resize() {
        int newCapacity = (int) ((size + 1) * 1.5);
        Object[] temp = new Object[newCapacity];
        System.arraycopy(stack, 0, temp, 0, size);
        size = stack.length;
        stack = temp;
    }
}
