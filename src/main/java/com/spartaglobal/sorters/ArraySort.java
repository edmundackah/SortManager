package com.spartaglobal.sorters;

import com.spartaglobal.controller.SortManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class ArraySort implements Sortable {
    private static String className = ArraySort.class.getCanonicalName();
    private static Logger logger = Logger.getLogger(className);

    @Override
    public int[] sort(int[] arr) {
        logger.debug("Starting Arrays.Sort");
        Arrays.sort(arr);
        logger.debug("Returning sorted array");

        return arr;
    }
}
