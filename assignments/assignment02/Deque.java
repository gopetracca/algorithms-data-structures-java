
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
        Node prev;
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
        Deque<String> deque1 = new Deque<>();
        deque1.addFirst("First");
        deque1.addFirst("Second - this should appear");
        String value1 = deque1.removeFirst();
        System.out.println(value1);

    }

}
