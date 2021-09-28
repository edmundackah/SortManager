package com.spartaglobal;



import com.spartaglobal.sorters.MergeSort;
import com.spartaglobal.sorters.*;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        int[] numbers  = {1, 98, 43, 77, 55, 99, 0, 1};

        Sortable sorter = new MergeSort();

        for( int a : sorter.sort(numbers)) {
            System.out.println(a);
        }
    }
}
