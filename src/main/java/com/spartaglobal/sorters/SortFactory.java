package com.spartaglobal.sorters;

import org.apache.log4j.Logger;

public class SortFactory {
    private static Logger logger = Logger.getLogger("Sorting Application");

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
}
