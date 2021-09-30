package com.spartaglobal.testing.sorters;

import com.spartaglobal.sorters.BubbleSort;
import com.spartaglobal.sorters.MergeSort;
import com.spartaglobal.sorters.QuickSort;
import com.spartaglobal.sorters.Sortable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSortTest {
    private final int[] testData = {45, 7, 1,  0, 5, 1, 7, 3};

    @Test
    public void sortArrayIntoOrder() {
        Sortable quickSort = new QuickSort();

        int[] sortedArray = {45, 7, 1,  0, 5, 1, 7, 3};
        Arrays.sort(sortedArray);

        Assertions.assertArrayEquals(quickSort.sort(testData), sortedArray);
    }

    @Test
    public void GivenAnEvenArray_SortIntoOrder() {
        final int[] evenTestArray = {45, 7, 1,  0, 5, 1};

        Sortable quickSort = new QuickSort();

        int[] sortedArray = {45, 7, 1,  0, 5, 1};
        Arrays.sort(sortedArray);

        Assertions.assertArrayEquals(quickSort.sort(evenTestArray), sortedArray);
    }
}
