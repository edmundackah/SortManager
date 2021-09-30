package com.spartaglobal.sorters;

import org.apache.log4j.Logger;

public class BubbleSort implements Sortable{
    private static Logger logger = Logger.getLogger("Sorting Application");

    @Override
    public int[] sort(int[] arr) {
        logger.debug("Attempting Bubble Sort");
        int temp;
        boolean swapMade = true;

        logger.debug("Busy sorting array [Bubble Sort]");
        while (swapMade) {
            swapMade = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapMade = true;
                }
            }
        }

        logger.debug("Returning Bubble Sort results");
        return arr;
    }
}
