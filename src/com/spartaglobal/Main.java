package com.spartaglobal;

import com.spartaglobal.sorters.MergeSort;
import com.spartaglobal.sorters.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String algoChoice = scanner.nextLine();

        if (algoChoice.contains("1") || algoChoice.equalsIgnoreCase("Bubble Sort")) {


        } else if (algoChoice.contains("2") || algoChoice.equalsIgnoreCase("Merge Sort")) {

        }

        int[] numbers  = {1, 98, 43, 77, 55, 99, 0, 1};

        Sortable sorter = new MergeSort();

        System.out.println(Arrays.toString(sorter.sort(numbers)));
    }
}
