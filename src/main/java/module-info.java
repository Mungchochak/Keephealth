module com.example.keephealth {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.example.keephealth to javafx.fxml;
    exports com.example.keephealth;
}