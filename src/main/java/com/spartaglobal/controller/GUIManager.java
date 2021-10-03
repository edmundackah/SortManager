package com.spartaglobal.controller;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class GUIManager {

    //TODO: Ask about GUI refactoring

    public void showDialog(String message) {
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Dialog");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(message);
        dialog.getDialogPane().getButtonTypes().add(type);

        dialog.showAndWait();
    }
}
