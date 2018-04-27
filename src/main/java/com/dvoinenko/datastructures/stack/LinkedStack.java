package com.dvoinenko.datastructures.stack;

import java.util.NoSuchElementException;

public class LinkedStack extends AbstractStack {
    private Node tail;

    // adding to the tail
    public void push(Object value){ // adding to end of stack
        Node newNode = new Node(value);
        if(size == 0) {
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("there is no such Node");
        } else {
            return tail.value;
        }
    }

    // removing from the tail
    public Object pop() { //deleting from end of stack
        Node temp;
        if (size == 0) {
            throw new NoSuchElementException("there is no such Node");
        } else {
            temp = tail;
            tail = tail.prev;
        }
        size--;
        return temp.value;
    }
}
