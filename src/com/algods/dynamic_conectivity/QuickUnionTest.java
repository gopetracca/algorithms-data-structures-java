package com.algods.dynamic_conectivity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickUnionTest {

    @Test
    void union() {
        int size = 10;
        QuickUnion algo = new QuickUnion(size);
        int p1 = 1, p2 = 2, p3 = 8;
        algo.union(p1, p2);
        assertTrue(algo.connected(p1, p2));
        assertFalse(algo.connected(p1, p3));
    }

    @Test
    void union_larger() {
        int size = 5;
        QuickUnion algo = new QuickUnion(size);
        algo.union(0, 1);
        algo.union(0, 4);
        algo.union(2, 3);
        int[] expected_id = new int[]{ 0, 0, 2, 2, 0};
        assertTrue(Arrays.equals(algo.id, expected_id));
    }

    @Test
    void getRoot(){
        int size = 10;
        QuickUnion algo = new QuickUnion(size);
        int[] fakeId = {0, 0, 1, 3, 4, 5, 6, 7, 8, 9};
        algo.id = fakeId;

        // both 1 and 2 have 0 as root node
        assertEquals(algo.getRoot(1), 0);
        assertEquals(algo.getRoot(2), 0);
        // no parents, so it is its own root
        assertEquals(algo.getRoot(9), 9);

    }
}
