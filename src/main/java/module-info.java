module com.spartaglobal {
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j;

    exports com.spartaglobal;
    opens com.spartaglobal to javafx.graphics;

    opens com.spartaglobal.controller to javafx.fxml;
    exports com.spartaglobal.controller;

    exports com.spartaglobal.util;
    opens com.spartaglobal.util to javafx.fxml;

    exports com.spartaglobal.view;
    opens com.spartaglobal.view to javafx.fxml;
}