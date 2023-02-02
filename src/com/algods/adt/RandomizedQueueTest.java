package com.algods.adt;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.collection.IsIn.isIn;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

class RandomizedQueueTest {

    @Test
    void isEmpty() {
        RandomizedQueue randQueue = new RandomizedQueue();
        assertTrue(randQueue.isEmpty());
        randQueue.enqueue(2);
        assertTrue(!randQueue.isEmpty());
    }

    @Test
    void size() {
        RandomizedQueue randQueue = new RandomizedQueue();
        assertEquals(0, randQueue.size());
        randQueue.enqueue(10);
        assertEquals(1, randQueue.size());
    }

    @Test
    void enqueue_deque() {
        RandomizedQueue randQueue = new RandomizedQueue();
        randQueue.enqueue("hello");
        assertEquals("hello", randQueue.dequeue());
    }

    @Test
    void enqueue_deque_random() {
        RandomizedQueue randQueue = new RandomizedQueue();
        randQueue.enqueue("hello");
        randQueue.enqueue("bye");
        assertThat(
                randQueue.dequeue(),
                isIn(new String[]{"hello", "bye"})
        );
        assertThat(
                randQueue.dequeue(),
                isIn(new String[]{"hello", "bye"})
        );
    }

    @Test
    void sample() {
        RandomizedQueue randQueue = new RandomizedQueue();
        randQueue.enqueue("hello");
        randQueue.enqueue("bye");
        assertThat(
                randQueue.sample(),
                isIn(new String[]{"hello", "bye"})
        );
        assertEquals(2, randQueue.size());
    }

    @Test
    void iterator() {
        RandomizedQueue<String> randQueue = new RandomizedQueue();
        randQueue.enqueue("value1");
        randQueue.enqueue("value2");
        randQueue.enqueue("value3");
        String[] expected = new String[]{"value1", "value2", "value3"};
        String[] result = new String[randQueue.size()];
        int i = 0;
        for (String elem : randQueue) {
            result[i] = elem;
            i++;
        }
        Arrays.sort(result);
        assertArrayEquals(expected, result);
    }
}