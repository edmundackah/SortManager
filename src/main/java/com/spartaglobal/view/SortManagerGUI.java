package com.spartaglobal.view;

import com.spartaglobal.sorters.SortFactory;
import com.spartaglobal.sorters.Sortable;
import javafx.application.Application;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class SortManagerGUI implements Initializable {
    private final String[] options = {"BubbleSort", "QuickSort", "MergeSort", "BinaryTree",
            "InsertionSort", "SelectionSort", "CollectionSort", "ArraySort", "ParallelSort"};

    private SortFactory sortFactory = new SortFactory();

    @FXML
    Tab logTab;

    @FXML
    TableColumn timeCol, algoCol, sortedCol;

    @FXML
    TableView<SortResults> resultTable;

    @FXML
    Slider rangeSlider;

    @FXML
    TabPane systemTab;

    @FXML
    ListView choiceLST;

    @FXML
    public void logTabSelectEvent() {

    }

    private void showDialog(String message) {
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Dialog");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(message);
        dialog.getDialogPane().getButtonTypes().add(type);

        dialog.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //enable multi selection on listview
        choiceLST.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //setting column properties
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        algoCol.setCellValueFactory(new PropertyValueFactory<>("algorithm"));
        sortedCol.setCellValueFactory(new PropertyValueFactory<>("sortedArr"));

        //checks to see if the log tab is the active tab and loads the logs
        systemTab.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if(newTab.equals (logTab)) {
                System.out.print("Log tab is selected");
            }
        });

        //load supported algorithms into listview
        choiceLST.getItems().addAll(options);
    }

    private void showSystemLogs() {

    }

    @FXML
    public void sortArray() {
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

    @FXML
    public void runBenchmark() {
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