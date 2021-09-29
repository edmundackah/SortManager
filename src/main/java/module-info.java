module com.example.sortmanager1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sortmanager1 to javafx.fxml;
    exports com.example.sortmanager1;
    exports com.spartaglobal.view;
    opens com.spartaglobal.view to javafx.fxml;
}