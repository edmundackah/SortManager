package com.spartaglobal.sorters;

import com.spartaglobal.controller.SortManager;
import org.apache.log4j.Logger;

public class InsertionSort implements Sortable {
    private static String className = InsertionSort.class.getCanonicalName();
    private static Logger logger = Logger.getLogger(className);

    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;

        logger.debug("Running insertion sort");

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
