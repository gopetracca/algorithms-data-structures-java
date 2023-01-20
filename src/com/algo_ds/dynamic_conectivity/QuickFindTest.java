package com.algo_ds.dynamic_conectivity;

import static org.junit.jupiter.api.Assertions.*;

class QuickFindTest {

    @org.junit.jupiter.api.Test
    void connected() {
        int size = 10;
        QuickFind algo = new QuickFind(size);
        algo.union(0,1);
        assertTrue(algo.connected(0,1));
    }

    @org.junit.jupiter.api.Test
    void union() {
        int size = 10;
        QuickFind algo = new QuickFind(size);
        algo.union(0,1);
        assertEquals(algo.getIdIndex(0), algo.getIdIndex(1));
        assertNotEquals(algo.getIdIndex(0), algo.getIdIndex(2));
    }

}