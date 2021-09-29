package com.spartaglobal.sorters;

public class QuickSort implements Sortable {
    @Override
    public int[] sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        quickSort(arr, low, high);

        return arr;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int splitIndex = split(arr, low, high);

            //recursive call left of pivot
            quickSort(arr, low, splitIndex - 1);

            //recurve call on right pivot
            quickSort(arr, splitIndex + 1, high);
        }
    }

    //method to find point to split array
    private int split(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int x = low; x < high; x++) {
            if (arr[x] <= pivot) {
                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                //swap contents of element at i with x
                int temp = arr[i];
                arr[i] = arr[x];
                arr[x] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


}
