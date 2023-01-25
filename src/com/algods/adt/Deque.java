package com.algods.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
        Node prev; // TODO: Do I need a reference to the previous one,?
    }

    private Node first;
    private Node last;
    private int N;
    // construct an empty deque
    public Deque() {}

    // is the deque empty?
    public boolean isEmpty() { return N == 0; }

    // return the number of items on the deque
    public int size() { return N; }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }
        Node prevFirst = this.first;
        first = new Node();
        first.item = item;
        first.prev = null;
        if (isEmpty()) {
            last = first;
            first.next = null;
        }
        else {
            first.next = prevFirst;
            prevFirst.prev = first;
        }

        N++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (!isEmpty()) {
            oldLast.next = last;
            last.prev = oldLast;
        }
        else { first = last; }

        N++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Deque is empty");
        }
        Node oldFirst = first;
        Item item = oldFirst.item;

        if (oldFirst.next != null) {
            first = oldFirst.next;
            first.prev = null;
        }
        N--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Deque is empty");
        }
        Node oldLast = last;
        Item item = oldLast.item;
        last = oldLast.prev;
        N--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
        {  return new LinkIterator();  }

    private class LinkIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next() {
            if (isEmpty()) { throw new NoSuchElementException(); }
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque1 = new Deque();
        deque1.addFirst("First");
        deque1.addFirst("Second - this should appear");
        String value1 = deque1.removeFirst();
        System.out.println(value1);

        Deque<String> deque2 = new Deque();
        deque2.addFirst("First - this should appear");
        deque2.addFirst("Second");
        String value2 = deque2.removeLast();
        System.out.println(value2);

        Deque<String> deque3 = new Deque();
        deque3.addLast("First");
        deque3.addLast("Second - this should appear");
        String value3 = deque3.removeLast();
        System.out.println(value3);

        Deque<String> deque4 = new Deque();
        deque4.addLast("First - this should appear");
        deque4.addLast("Second");
        String value4 = deque4.removeFirst();
        System.out.println(value4);


        Deque<String> deque5 = new Deque();
        deque5.addLast("First");
        deque5.addLast("Second");
        deque5.addLast("Third");
        System.out.println("Iterator test..");
        for (String value : deque5 ) {
            System.out.println(value);
        }
    }

}
