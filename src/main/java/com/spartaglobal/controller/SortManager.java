package com.spartaglobal.controller;

import com.spartaglobal.sorters.*;
import com.spartaglobal.view.DisplayManager;

import java.util.Random;

public class SortManager {
    private final DisplayManager view;
    private Sortable sort;

    public SortManager(DisplayManager view) {
        this.view = view;
    }

    public void selectAlgorithm() {
        SortFactory sortFactory = new SortFactory();
        sort = sortFactory.getSortable(view.selectAlgorithm());
    }

    public int[] sortArray() {
        int[] arr = new Random().ints(view.getArraySize(), 0, 100).toArray();

        view.displayArray("Unsorted Array:", arr, false);
        int[] sortedArr = sort.sort(arr);
        view.displayArray("Sorted Array:", sortedArr, true);

        return sortedArr;
    }
}
