module com.spartaglobal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.spartaglobal.controller to javafx.fxml;
    exports com.spartaglobal.controller;
    exports com.spartaglobal.view;
    opens com.spartaglobal.view to javafx.fxml;
}