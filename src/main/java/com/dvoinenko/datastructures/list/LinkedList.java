package com.dvoinenko.datastructures.list;

public class LinkedList extends AbstractList {
    Node head, tail;

    public void add(Object value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between 0 and size, but is" + index);
        }
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        }
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node current = getNode(index);

            current.prev.next = newNode;
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    public Object remove(int index) {
        validateIndex(index);
        Node current;
        if (size == 1) {
            current = head;
            head = tail = null;
        } else if (index == 0) {
            current = head;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            current = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            current = getNode(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.prev = null;
            current.next = null;
        }
        size--;
        return current.value;

    }

    public Object get(int index) {
        validateIndex(index);
        return getNode(index).value;
    }

    public Object set(Object value, int index) {
        validateIndex(index);
        Node current = getNode(index);
        Object oldValue = current.value;
        current.value = value;
        return oldValue;
    }

    public void clear() {
        Node current = head;
        while (current != tail) {
            Node nextNode = current.next;
            current.next = current.prev = null;
            current.value = null;
            current = nextNode;
        }
        head.next = tail.prev = null;
        size = 0;
    }

    public int indexOf(Object value) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        Node current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.value.equals(value)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    private Node getNode(int index) {
        validateIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
