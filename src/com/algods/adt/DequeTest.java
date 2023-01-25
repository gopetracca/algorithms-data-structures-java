package com.algods.adt;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void isEmpty() {
        Deque<Integer> deque = new Deque();
        assertTrue(deque.isEmpty());
        deque.addFirst(1);
        assertFalse(deque.isEmpty());
    }

    @Test
    void size() {
        Deque<Integer> deque = new Deque();
        assertEquals(0, deque.size());
        deque.addFirst(1);
        assertEquals(1, deque.size());
    }

    @Test
    void addFirst() {
        Deque<String> deque = new Deque();
        deque.addFirst("First");
        deque.addFirst("Second");
        deque.addFirst("Third");
        assertEquals("Third", deque.removeFirst());
        assertEquals("Second", deque.removeFirst());
    }
    @Test
    void addFirst_null() {
        Deque<String> deque = new Deque();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                deque.addFirst(null);;
            }
        );

        String expectedMessage = "item cannot be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void addLast() {
        Deque<String> deque = new Deque();
        deque.addLast("First");
        deque.addLast("Second");
        assertEquals("First", deque.removeFirst());
    }

    @Test
    void addLast_null() {
        Deque<String> deque = new Deque();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    deque.addLast(null);;
                }
        );

        String expectedMessage = "item cannot be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void removeFirst() {
        Deque<Integer> deque = new Deque();
        deque.addLast(1);
        deque.addLast(2);
        assertEquals(1, deque.removeFirst());
    }

    @Test
    void removeFirst_whenEmpty() {
        Deque deque = new Deque();
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
           deque.removeFirst();
        });
        String expected = "Deque is empty";
        String thrownMessage = exception.getMessage();
        assertEquals(expected, thrownMessage);
    }

    @Test
    void removeLast() {
        Deque<Integer> deque = new Deque();
        deque.addLast(1);
        deque.addLast(2);
        assertEquals(2, deque.removeLast());
    }

    @Test
    void removeLast_whenEmpty() {
        Deque deque = new Deque();
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            deque.removeLast();
        });
        String expected = "Deque is empty";
        String thrownMessage = exception.getMessage();
        assertEquals(expected, thrownMessage);
    }


    @Test
    void iterator_remove() {
        Deque deque = new Deque();
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            deque.iterator().remove();
        });
    }

    @Test
    void iterator_next_whenEmpty() {
        Deque deque = new Deque();
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            deque.iterator().next();
        });
    }

    @Test
    void iterator() {
        Deque<Integer> deque = new Deque();
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addFirst(0);
        int[] expected = new int[]{0, 1, 2};

        int[] result = new int[3];
        int index = 0;
        for (int value : deque) {
            result[index] = value;
            index++;
        }

        assertTrue(Arrays.equals(expected, result));

    }
}