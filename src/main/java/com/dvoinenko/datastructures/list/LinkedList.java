package com.dvoinenko.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class LinkedList extends AbstractList implements Iterable {
    private Node head;
    private Node tail;

    public void add(Object value, int index) {
        validateIndexToAdd(index);
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        }
        else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node current = getNode(index);

            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
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
        while (current != null) {
            Node nextNode = current.next;
            current.next = null;
            current.prev = null;
            current.value = null;
            current = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    public int indexOf(Object value) {
        int index = 0;
        if (value == null) {
            for (Node current = head; current != null; current = current.next) {
                if (current.value == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node current = head; current!= null; current = current.next) {
                if (value.equals(current.value)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        int index = size;
        if (value == null) {
            for (Node current = tail; current != null; current = current.prev) {
                index--;
                if (current.value == null) {
                    return index;
                }
            }
        } else {
            for (Node current = tail; current!= null; current = current.prev) {
                index--;
                if (value.equals(current.value)) {
                    return index;
                }
            }
        }
        return -1;
    }

    private Node getNode(int index) {
        validateIndex(index);
        Node current;
        if (index >= size/2) {
            current = tail;
            for (int i = size; i > index ; i--) {
                current = current.prev;
            }
        } else {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        return current;
    }

    public String toString() {
        StringJoiner result = new StringJoiner(",", "[", "]");
        Node current = head;
        while (current != null) {
            result.add(String.valueOf(current));
            current = current.next;
        }
        return String.valueOf(result);
    }

    private static class Node {
        private Object value;
        private Node prev;
        private Node next;

        private Node(Object value) {
            this.value = value;
        }
    }

    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {

        private Node nextNode = head;
        private Node prevNode = tail;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        public boolean hasPrevious() {
            return prevNode != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no such element in Linked List");
            }
            Object value = nextNode.value;
            nextNode = nextNode.next;
            return value;
        }

        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("There is no such element in Linked List");
            }
            Object value = prevNode.value;
            prevNode = prevNode.prev;
            return value;
        }
    }
}
