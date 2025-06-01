package com.praktikum.gui;

import com.praktikum.main.LoginSystem;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage){
        LoginSystem system = new LoginSystem();
        system.objectUser();
        LoginPane.show(stage);
    }
    public static void main(String[] args) {
        launch(args);
    }

}
