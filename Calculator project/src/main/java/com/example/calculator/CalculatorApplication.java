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
        FXMLLoader mainSceneLoader = new FXMLLoader(CalculatorApplication.class.getResource("MainScene.fxml"));
        Scene scene = new Scene(mainSceneLoader.load(), 900, 600);
        Image icon;
        icon = new Image("increase-font-size.png");
        stage.setTitle("Matrix Calculator");
        stage.getIcons().add(icon);
        stage.setScene(scene);

        MainController mainController = mainSceneLoader.getController();
        mainController.addMatrixPane(true, mainController.getLeftHeight());
        mainController.addMatrixPane(false, mainController.getRightHeight());

        stage.show();
    }
}