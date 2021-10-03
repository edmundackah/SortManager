package com.spartaglobal.view;

import com.spartaglobal.controller.GUIManager;
import com.spartaglobal.controller.SortManager;
import com.spartaglobal.sorters.SortFactory;
import com.spartaglobal.sorters.Sortable;
import com.spartaglobal.util.LogReader;
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
    private GUIManager guiManager;

    @FXML
    Tab logTab;

    @FXML
    TableColumn timeCol, algoCol, sortedCol, levelCol, timeStampCol, packageCol, methodCol, logCol;

    @FXML
    TableView<GUIManager.SortResults> resultTable;

    @FXML
    TableView<LogReader.LogEntry> logTable;

    @FXML
    Slider rangeSlider;

    @FXML
    TabPane systemTab;

    @FXML
    ListView choiceLST;

    public SortManagerGUI() {
        guiManager = new GUIManager();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //enable multi selection on listview
        choiceLST.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //setting result table column properties
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        algoCol.setCellValueFactory(new PropertyValueFactory<>("algorithm"));
        sortedCol.setCellValueFactory(new PropertyValueFactory<>("sortedArr"));

        //setting logging table column properties
        timeStampCol.setCellValueFactory(new PropertyValueFactory<>("timeStampCol"));
        logCol.setCellValueFactory(new PropertyValueFactory<>("logCol"));
        packageCol.setCellValueFactory(new PropertyValueFactory<>("packageCol"));
        levelCol.setCellValueFactory(new PropertyValueFactory<>("levelCol"));
        methodCol.setCellValueFactory(new PropertyValueFactory<>("methodCol"));

        //checks to see if the log tab is the active tab and loads the logs
        systemTab.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if(newTab.equals (logTab)) {
                GUIManager.showSystemLogs(logTable);
            }
        });

        //load supported algorithms into listview
        choiceLST.getItems().addAll(GUIManager.getOptions());
    }

    @FXML
    public void sortArray() {
        guiManager.runSortable(rangeSlider, resultTable, choiceLST);
    }

    @FXML
    public void runBenchmark() {
        guiManager.startBenchmark(choiceLST, resultTable);
    }
}