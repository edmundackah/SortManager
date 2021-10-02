package com.spartaglobal.sorters;

import com.spartaglobal.controller.SortManager;
import org.apache.log4j.Logger;

public class SelectionSort implements Sortable {
    private static String className = SelectionSort.class.getCanonicalName();
    private static Logger logger = Logger.getLogger(className);

    @Override
    public int[] sort(int[] arr) {
        logger.debug("Running selection sort");

        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        logger.debug("returning sorted array");
        return arr;
    }
}
