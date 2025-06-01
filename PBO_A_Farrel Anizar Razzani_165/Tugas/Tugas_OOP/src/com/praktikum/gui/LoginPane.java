package com.praktikum.gui;

import com.praktikum.main.LoginSystem;
import com.praktikum.users.Admin;
import com.praktikum.users.Student;
import com.praktikum.users.UserClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPane{
    public static void show(Stage stage){
        Label label = new Label("Login sistem Lost & Found");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Admin", "Mahasiswa");
        comboBox.setValue("Mahasiswa");

        TextField textField = new TextField();
        textField.setPromptText("Username");
        TextField textField2 = new TextField();
        textField2.setPromptText("Password");
        Button button = new Button("Login");
        Label messLabel = new Label();

        button.setOnAction(e -> {
            String type = comboBox.getValue();
            String user = textField.getText();
            String pass = textField2.getText();

            UserClass u = LoginSystem.login(user, pass, type);
                if(u == null){
                    messLabel.setText("Login gagal, Username/Password salah");
                }
                else if(u instanceof Admin){
                    new AdminDashboard().show(stage,(Admin) u);
                }
                else if(u instanceof Student ){
                    new MahasiswaDashboard().show(stage,(Student) u);
                }

        });

        VBox vBox = new VBox(10, label, comboBox, textField, textField2, button, messLabel);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(50));
        Scene scene = new Scene(vBox, 400,250);
        stage.setScene(scene);
        stage.setTitle("Lost & Found");
        stage.show();

    }

}