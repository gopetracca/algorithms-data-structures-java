package com.algo_ds.dynamic_conectivity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickUnionWeightedTest {

    @Test
    void union() {
        int size = 10;
        QuickUnion algo = new QuickUnion(size);
        int p1 = 1, p2 = 2, p3 = 8;
        algo.union(p1, p2);
        assertTrue(algo.connected(p1, p2));
        assertFalse(algo.connected(p1, p3));
    }
}