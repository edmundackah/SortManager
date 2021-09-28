package com.spartaglobal.controller;

import com.spartaglobal.sorters.BubbleSort;
import com.spartaglobal.sorters.MergeSort;
import com.spartaglobal.sorters.Sortable;

public class SortController {

    public static void main(String[] args) {
        Sortable sorter = getSortableFactory(0);
    }

    public static Sortable getSortableFactory(int index) {

        switch (index) {
            case 0:
                return new MergeSort();
            case 1:
                return new BubbleSort();
            default:
                return null;
        }
    }
}
