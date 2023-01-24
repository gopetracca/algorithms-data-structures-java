package com.algods.adt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void push_pop() {
        Stack stack = new Stack();
        stack.push("Hello");
        stack.push("GoodBye");
        assertEquals("GoodBye", stack.pop());
        stack.push("Middle");
        assertEquals("Middle", stack.pop());
        assertEquals("Hello", stack.pop());
    }

    @Test
    void getSize() {
        Stack stack = new Stack();
        assertEquals(0, stack.getSize());
        stack.push(1);
        assertEquals(1, stack.getSize());
    }

    @Test
    void isEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}