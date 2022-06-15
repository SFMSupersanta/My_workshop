package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {
    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Image icon;
        icon = new Image("increase-font-size.png");


        stage.setTitle("Hello!");
        stage.getIcons().add(icon);
        stage.setScene(scene);

        stage.show();
    }
}