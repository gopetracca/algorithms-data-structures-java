import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] arrayItems; // Queue of items
    private int N; // Size of the Queue

    // construct an empty randomized queue
    public RandomizedQueue() {
         arrayItems = (Item[]) new Object[1];
         N = 0;
    }

    // resize the underlying data structure to accommodate size of queue
    private void resizeArray(int capacity) {
        if (capacity < N) {
            throw new ArrayStoreException("capacity should be greater than size");
        }
        Item[] tmp = (Item[]) new Object[capacity];
        for (int i=0; i<this.N; i++) {
            tmp[i] = arrayItems[i];
        }
        arrayItems = tmp;
        tmp = null;
    }

    // is the randomized queue empty?
    public boolean isEmpty() { return N==0; }

    // return the number of items on the randomized queue
    public int size() { return N; }

    // add the item
    public void enqueue(Item item) {
        if (N == arrayItems.length) { resizeArray(2 * arrayItems.length); }
        arrayItems[N++] = item;
    }


    // remove and return a random item
    public Item dequeue() {
        // Get a random value for the index
        int index = StdRandom.uniformInt(0, N);
        Item element = arrayItems[index];
        arrayItems[index] = arrayItems[N-1];
        arrayItems[N-1] = null;
        N--;
        return element;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        int index = StdRandom.uniformInt(0, N);
        return arrayItems[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() { return new RandomIterator(); }

    private class RandomIterator implements Iterator<Item> {
        private Item[] copyArrayItems;
        private int copyN;

        public RandomIterator() {
            copyArrayItems = (Item[]) new Object[arrayItems.length];
            copyN = N;
            for (int i=0; i< arrayItems.length; i++) {
                copyArrayItems[i] = arrayItems[i];
            }
        }


        public boolean hasNext() { return copyN > 0; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next() {
            int randIndex = StdRandom.uniformInt(0, copyN);
            Item element = copyArrayItems[randIndex];
            copyArrayItems[randIndex] = copyArrayItems[copyN-1];
            copyArrayItems[copyN-1] = null;
            copyN--;
            return element;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

        RandomizedQueue<Integer> arr = new RandomizedQueue<>();
        arr.enqueue(10);
        arr.enqueue(20);
        arr.enqueue(30);
        for(int i : arr){
            System.out.println("element: " + i );
        }
    }



}
