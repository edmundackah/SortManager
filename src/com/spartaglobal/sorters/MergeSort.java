package com.spartaglobal.sorters;

public class MergeSort implements Sortable {
    @Override
    public int[] sort(int[] array) {
        if(array.length > 1)
        {
            int elementsInA1 = array.length / 2;
            int elementsInA2 = array.length - elementsInA1;
            // declare and initialize the two arrays once we've determined their sizes
            int[] arr1 = new int[elementsInA1];
            int[] arr2 = new int[elementsInA2];
            // copy the first part of 'array' into 'arr1', causing arr1 to become full
            System.arraycopy(array, 0, arr1, 0, elementsInA1);
            // copy the remaining elements of 'array' into 'arr2', causing arr2 to become full
            System.arraycopy(array, elementsInA1, arr2, elementsInA1 - elementsInA1, elementsInA1 + elementsInA2 - elementsInA1);
            arr1 = sort(arr1);
            arr2 = sort(arr2);

            int i = 0, j = 0, k = 0;
            while(arr1.length != j && arr2.length != k)
            {
                // if the current element of arr1 is less than current element of arr2
                if(arr1[j] < arr2[k])
                {
                    // copy the current element of arr1 into the final array
                    array[i] = arr1[j];
                    i++;
                    // increase the index of arr1 to avoid comparing the element
                    // which we've just added
                    j++;
                }
                // if the current element of arr2 is less than current element of arr1
                else
                {
                    // copy the current element of arr2 into the final array
                    array[i] = arr2[k];
                    i++;
                    k++;
                }
            }
            while(arr1.length != j)
            {
                array[i] = arr1[j];
                i++;
                j++;
            }
            while(arr2.length != k)
            {
                array[i] = arr2[k];
                i++;
                k++;
            }
        }
        return array;
    }
}
