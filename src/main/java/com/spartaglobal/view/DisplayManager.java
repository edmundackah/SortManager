package com.spartaglobal.view;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DisplayManager {
    private Scanner scan = new Scanner(System.in);
    private static Logger logger = Logger.getLogger("Sorting Application");
    private final ArrayList<Integer> options = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));

    public int selectAlgorithm() {
        int choice = 0;

        while (!options.contains(choice)) {
            System.out.println("Pick a sorting algorithm: \n1. Bubble Sort \n2. Merge Sort \n3. Quick Sort \n4. Binary Tree \n5. Exit ");

            //error handing if user enters a value that is not of type integer or is negative
            choice = validateChoice();
        }

        switch (choice) {
            case 1:
                System.out.println("\nYou have selected Bubble Sort\n");
                break;
            case 2:
                System.out.println("\nYou have selected Merge Sort\n");
                break;
            case 3:
                System.out.println("\nYou have selected Quick Sort\n");
                break;
            case 4:
                System.out.println("\nYou have selected Binary Tree\n");
                break;
            case 5:
                System.out.println("Terminating session");
                System.exit(0);
        }
        return choice;
    }

    public int getArraySize() {
        int choice = 0;

        while (choice < 1 || choice > 100) {
            System.out.println("How many numbers in the array (1-100)? ");

            //error handling if user enters a value that is not of type integer or is negative
            choice = validateChoice();
        }
        return choice;
    }

    private int validateChoice() {
        int choice;
        try {
            choice = Integer.parseInt(scan.nextLine());
            if (choice < 0) throw new NegativeArraySizeException();

        } catch (InputMismatchException|NumberFormatException e) {
            logger.warn("Please pick from the given range\n");
            System.err.println("Please pick from the given range\n");
            choice = 0;
        } catch (NegativeArraySizeException e) {
            logger.error(e);
            System.err.println("Input can't be negative\n");
            choice = 0;
        }
        return choice;
    }

    public void displayArray(String header, int[] array, boolean showTime) {
        System.out.println(header);
        
        logger.debug("Printing arrays to console");

        long startTime = System.nanoTime();
        System.out.println("\t" + Arrays.toString(array));
        if (showTime) {
            System.out.println("Sorting took: " + (System.nanoTime() - startTime) + "ns");
        }
    }
}
