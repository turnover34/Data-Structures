package com.dvoinenko.datastructures.queue;

public interface Queue {

    public void enqueue(Object value);

    public Object dequeue();

    public int size();
}
