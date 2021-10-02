package com.spartaglobal.sorters;

import com.spartaglobal.controller.SortManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ParallelSort implements Sortable {
    private static String className = ParallelSort.class.getCanonicalName();
    private static Logger logger = Logger.getLogger(className);

    @Override
    public int[] sort(int[] arr) {
        logger.debug("Starting parallel sort");
        Arrays.parallelSort(arr);
        logger.debug("Returning sorted array");

        return arr;
    }
}
