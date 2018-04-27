package com.dvoinenko.datastructures.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractQueueTest {
    Queue emptyQueue;

    public abstract Queue getQueue();

    @Before
    public void before() {
        emptyQueue = getQueue();
    }

    @Test
    public void testEnqueueAndDequeue() {
        emptyQueue.enqueue("E");
        emptyQueue.enqueue("D");
        emptyQueue.enqueue("C");
        emptyQueue.enqueue("B");
        emptyQueue.enqueue("A");


        assertEquals(5, emptyQueue.size());
        assertEquals("E", emptyQueue.dequeue());
        emptyQueue.dequeue();
        emptyQueue.dequeue();
        assertEquals(2, emptyQueue.size());
        assertEquals("B", emptyQueue.dequeue());
    }
}