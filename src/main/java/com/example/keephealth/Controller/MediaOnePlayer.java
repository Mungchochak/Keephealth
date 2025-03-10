package com.example.keephealth.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MediaOnePlayer {

        @FXML
        private MediaView Mediaplayerone;

        @FXML
        private Button backbutton;

        @FXML
        private Button playbutton;

        @FXML
        private Button pausebutton;




        //Show fitness first video
        private void showMedia(){

            URL videoURL = getClass().getResource("/Video/video1.mp4");

            Media media = new Media(videoURL.toString());

            MediaPlayer mediaPlayer = new MediaPlayer (media);

            Mediaplayerone.setMediaPlayer(mediaPlayer);

            Mediaplayerone.getMediaPlayer().play();

            playbutton.setOnAction(event -> {
                Mediaplayerone.getMediaPlayer().play();
            });

            pausebutton.setOnAction(event -> {
                Mediaplayerone.getMediaPlayer().pause();
            });

            backbutton.setOnAction(event -> {
                Mediaplayerone.getMediaPlayer().stop();
                try {
                    Stage stage = (Stage) backbutton.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/keephealth/WorkoutPlans-view.fxml"));
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);
                    stage.setTitle("Keephealth");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });



        }


        @FXML
        public void initialize() {
            showMedia();
        }



}
