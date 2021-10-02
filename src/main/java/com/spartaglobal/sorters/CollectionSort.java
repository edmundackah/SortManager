package com.spartaglobal.sorters;

import com.spartaglobal.controller.SortManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CollectionSort implements Sortable {
    private static String className = CollectionSort.class.getCanonicalName();
    private static Logger logger = Logger.getLogger(className);

    @Override
    public int[] sort(int[] arr) {
        logger.debug("Starting collection sort");
        ArrayList<Integer> temp = new ArrayList<>();
        for (int x : arr) {
            temp.add(x);
        }
        logger.debug("Returning sorted array");
        Collections.sort(temp);
        return temp.stream().mapToInt(i -> i).toArray();
    }
}
