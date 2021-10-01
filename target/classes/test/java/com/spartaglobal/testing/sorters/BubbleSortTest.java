package com.spartaglobal.testing.sorters;

import com.spartaglobal.sorters.BubbleSort;
import com.spartaglobal.sorters.Sortable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class BubbleSortTest {
    private final int[] testData = {45, 7, 1,  0, 5, 1, 7, 3};

    @Test
    public void sortArrayIntoOrder() {
        Sortable bubbleSort = new BubbleSort();

        int[] sortedArray = {45, 7, 1,  0, 5, 1, 7, 3};
        Arrays.sort(sortedArray);

        Assertions.assertArrayEquals(bubbleSort.sort(testData),sortedArray);
    }

}
