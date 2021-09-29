package com.spartaglobal.sorters;

public class BubbleSort implements Sortable{
    @Override
    public int[] sort(int[] arr) {
        int temp;
        boolean swapMade = true;

        while (swapMade) {
            swapMade = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapMade = true;
                }
            }
        }

        return arr;
    }
}
