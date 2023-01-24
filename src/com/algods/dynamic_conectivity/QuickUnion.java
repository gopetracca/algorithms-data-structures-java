package com.algods.dynamic_conectivity;

public class QuickUnion extends QuickFind {

    public QuickUnion(int size) {
        super(size);
    }

    /***
     * Union two points.
     * We use the same DS as in QuickFind, but we change the interpretation of it.
     * The array now describes a tree and holds the id of its parent.
     * @param p fist point
     * @param q second point
     */
    @Override
    public void union(int p, int q){
        int rootP = getRoot(p);
        int rootQ = getRoot(q);
        // replace p root with q root
        id[q] = rootP;

    }

    /***
     * Get the root of the current point. Must iterate until reaches a root node.
     * @param p the point from which we want to get the root
     * @return the root of `p`
     */
    public int getRoot(int p) {
        while (id[p] != p){
            p = id[p];
        }
        return p;
    }
}
