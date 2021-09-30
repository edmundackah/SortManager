package com.spartaglobal.sorters;

public class SortFactory {

    public Sortable getSortable(int index) {
        switch (index) {
            case 1:
                return new BubbleSort();
            case 2:
                return new MergeSort();
            case 3:
                return new QuickSort();
            default:
                return null;
        }
    }
}
