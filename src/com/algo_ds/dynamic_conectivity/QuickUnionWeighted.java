package com.algo_ds.dynamic_conectivity;

/***
 * Union-Find algorithm using weighted trees in the union method.
 */
public class QuickUnionWeighted extends QuickUnion {
    int[] branch_size;
    public QuickUnionWeighted(int size){
        super(size);

        // initialize the size of each branch to 1 (self-rooted)
        for (int i=0; i<size; i++){
            branch_size[i] = 1;
        }
    }

    /***
     * Use weighted trees for the union.
     * Add the smaller tree to the bigger tree, to avoid skinny long trees.
     * To achieve this, we need an extra DS to hold the size of each root.
     * @param p fist point
     * @param q second point
     */
    @Override
    public void union(int p, int q) {

        int rootP = getRoot(p);
        int rootQ = getRoot(q);
        // Check if both roots are equal and return if True.
        if (rootP == rootQ) return;

        // Make the smaller tree child of the bigger tree.
        if (branch_size[rootP] < branch_size[rootQ]) {
            id[rootP] = rootQ;
            branch_size[rootQ] += branch_size[rootP];
        }
        else {
            id[rootQ] = rootP;
            branch_size[rootP] += branch_size[rootQ];
        }

    }
}
