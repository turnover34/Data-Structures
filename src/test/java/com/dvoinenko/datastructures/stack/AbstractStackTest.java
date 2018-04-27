package com.dvoinenko.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStackTest {
    Stack emptyStack;
    Stack fiveElementStack;

    public abstract Stack getStack();

    @Before
    public void before() {
        emptyStack = getStack();
        fiveElementStack = getStack();
        char symbol = 'E';
        for (int i = 5; i > 0 ; i--) {
            fiveElementStack.push(String.valueOf(symbol));
            symbol--;
        }
    }

    @Test
    public void testPushAndPeek() {
        emptyStack.push("D");
        emptyStack.push("C");

        assertEquals("C", emptyStack.peek());
        emptyStack.push("B");
        emptyStack.push("A");
        assertEquals("A", emptyStack.peek());
        assertEquals(4, emptyStack.size());
    }

    @Test
    public void testPop() {
        fiveElementStack.pop();
        fiveElementStack.pop();
        assertEquals(3, fiveElementStack.size());
        assertEquals("C", fiveElementStack.peek());
        fiveElementStack.pop();
        assertEquals("D", fiveElementStack.pop());
        assertEquals(1, fiveElementStack.size());
    }
}