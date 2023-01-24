package com.algods.adt;

public class Stack<Item> {
    private int size = 0;
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    public void push(Item item){
        Node prevFirst = first;
        first = new Node();
        first.item = item;
        first.next = prevFirst;
        size++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }
    public int getSize() { return size; }

    public boolean isEmpty() { return size == 0; }
}
