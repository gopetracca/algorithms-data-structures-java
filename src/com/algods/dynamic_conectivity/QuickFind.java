package com.algods.dynamic_conectivity;

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
    /***
     * Union two points.
     * Needs to change all the objects id[p] to id[q].
     * N union commands on N objects becomes O(n)=n^2
     * @param p fist point
     * @param q second point
     */
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
}
