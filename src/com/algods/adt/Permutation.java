
import com.algods.adt.RandomizedQueue;
import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    /***
     * Example run:
     *  cd out/production/algorithms_data_structures
     *  java -cp "../../../lib/algs4.jar:$PWD" com.algods.adt.Permutation 5 <  ../../../data/queues/duplicates.txt
     * @param args
     */
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);

        RandomizedQueue rQueue = new RandomizedQueue();
        // Read stdin until no more data left
        while (!StdIn.isEmpty()) {
            rQueue.enqueue(StdIn.readString());
        }

        // print output k number of times
        for (int i=0; i<k; i++) {
            System.out.println(rQueue.dequeue());
        }
    }
}
