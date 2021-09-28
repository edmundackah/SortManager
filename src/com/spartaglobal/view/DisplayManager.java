package com.spartaglobal.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DisplayManager {
    private Scanner scan = new Scanner(System.in);
    private final ArrayList<Integer> options = new ArrayList(Arrays.asList(1, 2, 3));

    public int selectAlgorithm() {
        int choice = 0;
        boolean hasChosen = false;

        while (!options.contains(choice)) {
            System.out.println("Pick a sorting algorithm: \n1. Bubble Sort \n2. Merge Sort \n3. Exit \n");

            //error handing if user enters a value that is not of type integer
            try {
                choice = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please pick from the given range\n");
                choice = 0;
            }
        }

        switch (choice) {
            case 1:
                System.out.println("\nYou have selected Bubble Sort\n");
                break;
            case 2:
                System.out.println("\nYou have selected Merge Sort\n");
                break;
            case 3:
                System.out.println("Terminating session");
                System.exit(0);
        }
        return choice;
    }

    public int setArraySize() {
        int choice = 0;

        while (choice < 1 || choice > 1000) {
            System.out.println("How many numbers in the array (1-1000)? ");

            //reset choice to zero if user enters an undesired input
            try {
                choice = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nPlease pick from the given range\n");
                choice = 0;
            }
        }
        return choice;
    }

    public void displayArray(String header, int[] array, boolean showTime) {
        System.out.println(header);
        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(array));
        if (showTime) {
            System.out.println("Sorting took: " + (System.nanoTime() - startTime) + "ns");
        }
    }
}
