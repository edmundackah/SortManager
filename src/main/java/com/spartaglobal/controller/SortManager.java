package com.spartaglobal.controller;

import com.spartaglobal.sorters.*;
import com.spartaglobal.view.DisplayManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SortManager {
    private final DisplayManager view;
    private Sortable sort;
    private static Logger logger = Logger.getLogger("Sorting Application");
    private int algoChoice, arraySize;

    public void setAlgoChoice(int algoChoice) {
        this.algoChoice = algoChoice;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public SortManager(DisplayManager view) {
        this.view = view;
    }

    public int getAlgoChoice() {
        return algoChoice;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void selectAlgorithm() {
        SortFactory sortFactory = new SortFactory();
        algoChoice = view.selectAlgorithm();
        sort = sortFactory.getSortable(getAlgoChoice());

        arraySize = view.getArraySize();
    }

    public int[] sortArray() throws Exception {
        int[] sortedArr = new int[0];

        logger.debug("Generating random number array");
        int[] arr = new Random().ints(getArraySize(), 0, 100).toArray();

        //ensures random numbers are unique
        /*
        int[] arr = ThreadLocalRandom.current()
                .ints(0, 500)
                .distinct().limit(getArraySize()).toArray();
         */

        boolean hasDuplicate = Arrays.stream(arr).distinct().count() < arr.length;
        if ( hasDuplicate && getAlgoChoice() == 4) {
            logger.warn("Binary Tree will remove duplicate values");

            view.displayArray("Unsorted Array:", arr, false);
            throw new Exception("\nBinary Tree cannot have duplicate values!\nTerminating sort");
        }
        view.displayArray("Unsorted Array:", arr, false);
        sortedArr = sort.sort(arr);
        view.displayArray("Sorted Array:", sortedArr, true);

        return sortedArr;
    }
}
