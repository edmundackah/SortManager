package com.spartaglobal.sorters;

import com.spartaglobal.controller.SortManager;
import org.apache.log4j.Logger;

public class SortFactory {
    private static String className = SortFactory.class.getCanonicalName();
    private static Logger logger = Logger.getLogger(className);

    public Sortable getSortable(int index) {
        logger.debug("Instantiating sorting Object");

        switch (index) {
            case 1:
                return new BubbleSort();
            case 2:
                return new MergeSort();
            case 3:
                return new QuickSort();
            case 4:
                return new TreeDriver();
            default:
                logger.error("Unable to find required Sortable");
                return null;
        }
    }

    public Sortable getGUISortable(int index) {
        logger.debug("Instantiating sorting Object");

        switch (index) {
            case 0:
                return new BubbleSort();
            case 1:
                return new QuickSort();
            case 2:
                return new MergeSort();
            case 3:
                return new TreeDriver();
            case 4:
                return new InsertionSort();
            case 5:
                return new SelectionSort();
            case 6:
                return new CollectionSort();
            case 7:
                return new ArraySort();
            case 8:
                return new ParallelSort();
            default:
                logger.error("Unable to find required Sortable. choice index: " + index);
                return null;
        }
    }
}
