package com.algo_ds.adt;

/***
 * Implement a FIFO Queue using a Linked List.
 * @param <Item>
 */
public class Queue<Item> {
    private Node first; // Least recently added element
    private Node last; // Most recently added element
    private int size; // Number of items in the queue
    private class Node{
        Item item;
        Node next;
    }

    public int size() { return this.size; }
    public boolean isEmpty() { return this.first == null; }
    public void enqueue(Item item) {
        // temporary store the previous last Node
        Node prevLast = this.last;
        // create and populate the new last node
        last = new Node();
        last.item = item;
        last.next = null;
        // Check if the queue is empty and assign the new node as first and last
        if (isEmpty()) { this.first = last; }
        // Change pointer to the new last node
        else prevLast.next = last;
        // Increase the size
        size++;
    }

    public Item deque(){
        Node prevFirst = this.first;
        first = prevFirst.next;
        return prevFirst.item;
    }

    public static void main(String args[]) {
        Queue fifo = new Queue<Integer>();
        fifo.enqueue(1);
        fifo.enqueue(5);
        int result1 = (Integer) fifo.deque();
        assert (result1 == 1);
        System.out.println("The next element in the queue is: " + result1);
        int result2 = (Integer) fifo.deque();
        System.out.println("The next element in the queue is: " + result2);
    }
}
