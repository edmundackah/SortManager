package com.spartaglobal.sorters;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ParallelSort implements Sortable {
    private static Logger logger = Logger.getLogger("Sorting Application");

    @Override
    public int[] sort(int[] arr) {
        logger.debug("Starting parallel sort");
        Arrays.parallelSort(arr);
        logger.debug("Returning sorted array");

        return arr;
    }
}
