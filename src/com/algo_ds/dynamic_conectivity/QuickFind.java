package com.algo_ds.dynamic_conectivity;

public class QuickFind {
    public int id[];
    public QuickFind(int size) {
        id = new int[size];
        for (int i=0; i<size; i++){
            id[i] = i;
        }
    }
    public int getIdIndex(int index){
        return id[index];
    }
    public boolean connected(int p, int q){
        return (id[p] == id[q]);
    }

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        // Change all entries with id[p] to id[q].
        for (int i=0; i<id.length; i++){
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public static void main(String args[]){
        System.out.println("Initializing the Algo");
        int size = 10;
        QuickFind algo = new QuickFind(size);
        algo.union(0,1);
        algo.union(9, 0);
        boolean check = algo.connected(9,1);
        System.out.println("Should be true: " + check);
        System.out.println("Should be false: " + algo.connected(9,3));
    }
}
