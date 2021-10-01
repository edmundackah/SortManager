package com.spartaglobal.testing.sorters;

import com.spartaglobal.sorters.MergeSort;
import com.spartaglobal.sorters.Sortable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortTest {
    private final int[] testData = {45, 7, 1,  0, 5, 1, 7, 3};

    @Test
    public void sortArrayIntoOrder() {
        Sortable mergeSort = new MergeSort();

        int[] sortedArray = {45, 7, 1,  0, 5, 1, 7, 3};
        Arrays.sort(sortedArray);

        Assertions.assertArrayEquals(mergeSort.sort(testData), sortedArray);
    }

    @Test
    public void GivenAnEvenArray_SortIntoOrder() {
        final int[] evenTestArray = {45, 7, 1,  0, 5, 1};

        Sortable mergeSort = new MergeSort();

        int[] sortedArray = {45, 7, 1,  0, 5, 1};
        Arrays.sort(sortedArray);

        Assertions.assertArrayEquals(mergeSort.sort(evenTestArray), sortedArray);
    }
}
