package com.dvoinenko.datastructures.queue;

public class LinkedQueue extends AbstractQueue {
    private Node head, tail;

    public LinkedQueue() {
    }

    // adding to the tail
    public void enqueue(Object value) { // adding element to start of queue
        Node newNode = new Node(value);
        if(size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // removing from the head
    public Object dequeue() { // deleting from end of queue
        Object result = head.value;
        head = head.next;
        size--;
        return result;
    }
}
