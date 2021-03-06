package com.spartaglobal.controller;

import com.spartaglobal.sorters.SortFactory;
import com.spartaglobal.util.LogReader;
import com.spartaglobal.view.SortManagerGUI;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class GUIManager {

    //TODO: Ask about GUI refactoring
    private static final String[] options = {"BubbleSort", "QuickSort", "MergeSort", "BinaryTree",
            "InsertionSort", "SelectionSort", "CollectionSort", "ArraySort", "ParallelSort"};

    private SortFactory sortFactory = new SortFactory();

    public static String[] getOptions() {
        return options;
    }

    private void showDialog(String message) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Dialog");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(message);
        dialog.getDialogPane().getButtonTypes().add(type);

        dialog.showAndWait();
    }

    public static void showSystemLogs(TableView logTable) {
        //clear existing logs from ui
        logTable.getItems().clear();

        //populating table with logs
        logTable.setItems(LogReader.getInstance().getSystemLogs());
        logTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void runSortable(Slider rangeSlider, TableView resultTable, ListView choiceLST) {
        int arrSize = (int) rangeSlider.getValue();

        ObservableList<SortResults> sortResults = FXCollections.observableArrayList();
        System.out.println(choiceLST.getSelectionModel().getSelectedIndices());

        ObservableList<Integer> choice = choiceLST.getSelectionModel().getSelectedIndices();

        if (arrSize < 1 || choice.isEmpty()) {
            //array size is zero and no algorithm(s) selected
            //show warning dialog
            showDialog("Slider must be greater than 1\nPlease select at least one algorithm");

        } else {
            //clear table
            resultTable.getItems().clear();

            //generate random array
            final int[] randomArray = ThreadLocalRandom.current().ints(0, 145)
                    .distinct().limit(arrSize).toArray();

            //run sortables against the array
            for (int c : choice) {
                long startTime = System.nanoTime();
                int[] sortedArr = sortFactory.getGUISortable(c).sort(randomArray);
                long endTime = System.nanoTime() - startTime;
                sortResults.add(
                        new SortResults(endTime, options[c], Arrays.toString(sortedArr))
                );
            }

            //populating table with data
            resultTable.setItems(sortResults);
            resultTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }
    }

    public void startBenchmark(ListView choiceLST, TableView resultTable) {
        ObservableList<SortResults> sortResults = FXCollections.observableArrayList();
        ObservableList<Integer> choice = choiceLST.getSelectionModel().getSelectedIndices();

        if (choice.isEmpty()) {
            //array size is zero and no algorithm(s) selected
            //show warning dialog
            showDialog("Please select at least one algorithm");

        } else {
            //clear table
            resultTable.getItems().clear();

            //will generate random arrays of the following lengths for the benchmark
            int[] benchmarkLengths = {5, 14, 22, 37, 56, 72 , 88, 100, 111, 120};

            //generate 10 arrays of varying lengths and store the average sorting time
            ArrayList<ArrayList<Integer>> nestedArr = new ArrayList<>();

            //generate random nested array
            for (int i : benchmarkLengths) {
                int[] randomArray = ThreadLocalRandom.current().ints(0, 145)
                        .distinct().limit(i).toArray();

                ArrayList<Integer> temp = new ArrayList<>();
                for (int k : randomArray) {
                    temp.add(k);
                }

                nestedArr.add(temp);
            }

            //run sortables against the array
            for (int c : choice) {
                ArrayList<Long> sortTimes = new ArrayList<>();

                //iterate through test cases
                for (ArrayList<Integer> arr : nestedArr) {
                    long startTime = System.nanoTime();
                    //running test case
                    sortFactory.getGUISortable(c)
                            .sort(arr.stream().mapToInt(i -> i).toArray());
                    //saving srt time to array
                    sortTimes.add(System.nanoTime() - startTime);
                }

                //saving benchmark results and average sorting time
                long averageSortingTime = (long) sortTimes.stream()
                        .mapToDouble(d -> d)
                        .average()
                        .orElse(0.0);

                sortResults.add(
                        new SortResults(averageSortingTime, options[c],
                                "Benchmarked " + benchmarkLengths.length +
                                        " varying arrays to find the average sorting time")
                );
            }

            //populating table with data
            resultTable.setItems(sortResults);
            resultTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }
    }

    public class SortResults {
        public SimpleLongProperty time;
        public SimpleStringProperty algorithm, sortedArr;

        public SortResults(long time, String algorithm, String sortedArr) {
            this.time = new SimpleLongProperty(time);
            this.algorithm = new SimpleStringProperty(algorithm);
            this.sortedArr = new SimpleStringProperty(sortedArr);
        }

        public long getTime() {
            return time.get();
        }

        public String getAlgorithm() {
            return algorithm.get();
        }

        public String getSortedArr() {
            return sortedArr.get();
        }
    }
}
