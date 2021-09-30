package com.spartaglobal;

import com.spartaglobal.sorters.BinarySearchTree;
import com.spartaglobal.sorters.QuickSort;
import com.spartaglobal.sorters.Sortable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers  = {1, 98, 43, 77, 55, 99, 0, 1};

        //Sortable sorter = new QuickSort();

        //System.out.println(Arrays.toString(sorter.sort(numbers)));

        Sortable sorter = new BinarySearchTree();

        System.out.println(Arrays.toString(sorter.sort(numbers)));
    }
}
