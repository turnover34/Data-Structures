package com.dvoinenko.datastructures.queue;

import java.util.NoSuchElementException;

public class ArrayQueue extends AbstractQueue {
    private int capacity;
    private Object[] queue;
    private static final int INITIAL_CAPACITY = 5;

    public ArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
    }

    public void enqueue(Object value) {
        if(isFull()) {
            resize();
        }
        queue[size++] = value;
    }

    public Object dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        Object toRemove = queue[0];
        System.arraycopy(queue, 1, queue, 0, size - 1);
        size--;
        return toRemove;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size  == queue.length;
    }

    private void resize() {
        int newCapacity = (int) ((size + 1) * 1.5);
        Object temp[] = new Object [newCapacity];
        System.arraycopy(queue, 0, temp, 0, size);
        size = queue.length - 1;
        queue = temp;
    }
}
