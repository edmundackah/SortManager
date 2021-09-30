package com.spartaglobal;

import com.spartaglobal.sorters.BinaryTree;
import com.spartaglobal.sorters.Sortable;
import com.spartaglobal.sorters.TreeDriver;

import java.util.Arrays;

public class Main {
    //TODO: Raise issue with Neil and Cathy
        //duplicate values deleted when sorting
    public static void main(String[] args) {
        //int[] numbers  = {1, 98, 43, 77, 55, 99, 0, 1};

        int[] numbers = {45, 7, 1,  0, 5, 1};

        //Sortable sorter = new QuickSort();

        System.out.println();

        //System.out.println(Arrays.toString(sorter.sort(numbers)));

        Sortable sorter = new TreeDriver();

        System.out.println(Arrays.toString(sorter.sort(numbers)));

    }
}
