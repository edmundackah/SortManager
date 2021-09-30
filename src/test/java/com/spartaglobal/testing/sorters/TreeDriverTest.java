package com.spartaglobal.testing.sorters;

import com.spartaglobal.sorters.MergeSort;
import com.spartaglobal.sorters.Sortable;
import com.spartaglobal.sorters.TreeDriver;
import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TreeDriverTest {
    private final int[] testData = {45, 7, 1,  0, 5, 1, 7, 3};

    @Test
    public void sortArrayIntoOrder() {
        Sortable treeDriver = new TreeDriver();

        int[] sortedArray = {45, 7, 1,  0, 5, 1, 7, 3};
        Arrays.sort(sortedArray);

        Assertions.assertArrayEquals(treeDriver.sort(testData), sortedArray);
    }
}
