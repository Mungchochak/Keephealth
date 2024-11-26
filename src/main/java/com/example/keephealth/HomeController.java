package com.example.keephealth;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Button LogoutButton;

    @FXML
    private void handleLogoutButton() {
            try {
                Stage stage = (Stage) LogoutButton.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/Login-view.fxml"));
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                stage.setTitle("Keephealth");
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
