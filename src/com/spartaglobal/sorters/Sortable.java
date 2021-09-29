package com.spartaglobal.sorters;

public interface Sortable {

    //all sorting algorithms implement this interface and the sort method
    //adhering to OCP principle
    int[] sort(int[] arr);
}
