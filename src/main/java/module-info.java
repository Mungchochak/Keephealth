module com.example.keephealth {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.example.keephealth to javafx.fxml;
    exports com.example.keephealth;
    exports com.example.keephealth.Model;
    opens com.example.keephealth.Model to javafx.fxml;
    exports com.example.keephealth.controller;
    opens com.example.keephealth.controller to javafx.fxml;
}