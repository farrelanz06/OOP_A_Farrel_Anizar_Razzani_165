package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import com.praktikum.users.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MahasiswaDashboard{
    public static void show(Stage stage, Student user){
        Label label = new Label("Selamat datang , " + user.getName());
        Label label2 = new Label("Laporkan barang hilang/temuan");
        TextField textField = new TextField();
        textField.setPromptText("Nama barang");
        TextField textField2 = new TextField();
        textField2.setPromptText("Deskripsi");
        TextField textField3 = new TextField();
        textField3.setPromptText("Lokasi");
        Label label3 = new Label("Daftar laporan anda");
        Button button = new Button("Laporkan");
        Button button2 = new Button("Logout");

        TableView<Item> tableView = new TableView<>();
        ObservableList<Item> data = FXCollections.observableList(LoginSystem.reportedItems);

        tableView.setItems(LoginSystem.reportedItems);
        tableView.getColumns().addAll(
                createColumn("Nama", "itemName"),
                createColumn("Lokasi", "location"),
                createColumn("Status", "status")
        );


        button.setOnAction(e -> {
            String nama = textField.getText();
            String deskripsi = textField2.getText();
            String lokasi = textField3.getText();

            if(!nama.isEmpty() && !lokasi.isEmpty()){
                Item item = new Item(nama, deskripsi, lokasi, "Reported");
                LoginSystem.reportedItems.add(item);

                textField.clear();
                textField2.clear();
                textField3.clear();
            }

        });

        button2.setOnAction(e -> LoginPane.show(stage));

        HBox hBox = new HBox(10, textField, textField2, textField3, button);

        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(10, label, label2, hBox, label3, tableView, button2);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.TOP_LEFT);

        stage.setScene(new Scene(vBox, 700,500));
        stage.setTitle("Mahasiswa");


    }
    private static TableColumn<Item, String> createColumn (String title, String property) {
        TableColumn<Item, String> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property));
        return col;
    }

}