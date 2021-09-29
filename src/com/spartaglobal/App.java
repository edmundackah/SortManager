package com.spartaglobal;

import com.spartaglobal.controller.SortManager;
import com.spartaglobal.sorters.MergeSort;
import com.spartaglobal.sorters.*;
import com.spartaglobal.view.DisplayManager;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        SortManager controller = new SortManager(new DisplayManager());
        controller.getSortableFactory();
        controller.sortArray();
    }
}
