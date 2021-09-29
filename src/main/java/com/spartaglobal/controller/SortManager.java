package com.spartaglobal.controller;

import com.spartaglobal.sorters.BubbleSort;
import com.spartaglobal.sorters.MergeSort;
import com.spartaglobal.sorters.QuickSort;
import com.spartaglobal.sorters.Sortable;
import com.spartaglobal.view.DisplayManager;

import java.util.Random;

public class SortManager {
    private final DisplayManager view;
    private Sortable sort;

    public SortManager(DisplayManager view) {
        this.view = view;
    }

    public void getSortableFactory() {
        switch (view.selectAlgorithm()) {
            case 1:
                sort = new BubbleSort();
                break;
            case 2:
                sort = new MergeSort();
                break;
            case 3:
                sort = new QuickSort();
                break;
            default:
                sort =  null;
        }
    }

    public void sortArray() {
        int[] arr = new Random().ints(view.getArraySize(), 0, 100).toArray();
        view.displayArray("Unsorted Array:", arr, false);
        sort.sort(arr);
        view.displayArray("Sorted Array:", arr, true);

    }
}
