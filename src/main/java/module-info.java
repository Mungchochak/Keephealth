module com.example.keephealth {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;

    opens com.example.keephealth to javafx.fxml;
    exports com.example.keephealth;
    exports com.example.keephealth.Model;
    opens com.example.keephealth.Model to javafx.fxml;
    exports com.example.keephealth.Controller;
    opens com.example.keephealth.Controller to javafx.fxml;
}