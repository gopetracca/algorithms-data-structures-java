package com.algods.adt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void size() {
        Queue fifo = new Queue<Integer>();
        fifo.enqueue(1);
        fifo.enqueue(9);
        assertEquals(2, fifo.size());
    }

    @Test
    void isEmpty() {
        Queue fifo = new Queue<Integer>();
        assertTrue(fifo.isEmpty());
        fifo.enqueue(1);
        assertFalse(fifo.isEmpty());
    }

    @Test
    void enqueue_deque() {
        Queue<String> fifo = new Queue<String>();
        fifo.enqueue("Hello");
        fifo.enqueue("second hello");
        assertEquals("Hello", fifo.deque());
        fifo.enqueue("third hello");
        assertEquals("second hello", fifo.deque());
        assertEquals("third hello", fifo.deque());

    }

}