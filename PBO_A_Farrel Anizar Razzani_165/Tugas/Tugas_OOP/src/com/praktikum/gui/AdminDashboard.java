package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import com.praktikum.users.Admin;
import com.praktikum.users.Student;
import com.praktikum.users.UserClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AdminDashboard{
    public static void show(Stage stage, Admin user){
        Label label = new Label("Halo, " + user.getName());
        Label label2 = new Label("Laporan barang");
        Label label3 = new Label("Data mahasiswa");
        Button button = new Button("Tandai claimed");
        Button button2 = new Button("Logout");
        Button button3 = new Button("Tambah mahasiswa");
        button3.setPrefWidth(50);
        Button button4 = new Button("Hapus mahasiswa");
        button4.setPrefWidth(50);
        TextField textField = new TextField();
        textField.setPromptText("Nama mahasiswa");
        textField.setPrefWidth(90);
        TextField textField2 = new TextField();
        textField2.setPromptText("NIM");
        textField2.setPrefWidth(90);

        TableView<Item> tableView = new TableView<>();
        ObservableList<Item> itemData = FXCollections.observableArrayList(LoginSystem.reportedItems);
        tableView.setItems(itemData);

        tableView.getColumns().addAll(
                createColumn("Nama", "itemName"),
                createColumn("Lokasi", "location"),
                createColumn("Status", "status")
        );

        button.setOnAction(e -> {
            Item selected = tableView.getSelectionModel().getSelectedItem();
            if(selected != null && selected.getStatus().equals("Reported")){
                selected.setStatus("Claimed");
                tableView.refresh();
            }
        });

        TableView<Student> tableView2 = new TableView<>();
        ObservableList<Student> mahasiswaList = FXCollections.observableArrayList();
        for(UserClass u : LoginSystem.userlist){
            if(u instanceof Student){
                mahasiswaList.add((Student) u);
            }
        }
        tableView2.setItems(mahasiswaList);
        tableView2.getColumns().addAll(
                createColumn("Nama", "name"),
                createColumn("NIM", "id")
        );

        button2.setOnAction(e -> LoginPane.show(stage));

        button3.setOnAction(e -> {
            String nama = textField.getText();
            String nim = textField2.getText();
            if(!nama.isEmpty() && !nim.isEmpty()){
                Student student = new Student(nama, nim);
                LoginSystem.userlist.add(student);
                tableView2.getItems().add(student);
                textField.clear();
                textField2.clear();
            }
        });
        button4.setOnAction(e -> {
            Student selected = tableView2.getSelectionModel().getSelectedItem();
            if(selected != null){
                LoginSystem.userlist.remove(selected);
                tableView2.getItems().remove(selected);
            }
        });

        VBox vBox2 = new VBox(5, label2, tableView);
        vBox2.setPadding(new Insets(10));
        vBox2.setAlignment(Pos.TOP_LEFT);
        vBox2.setPrefWidth(320);

        VBox vBox3 = new VBox(5, label3, tableView2);
        vBox3.setPadding(new Insets(10));
        vBox3.setAlignment(Pos.TOP_LEFT);
        vBox3.setPrefWidth(320);

        HBox hBox = new HBox(20, vBox2, vBox3);
        hBox.setPadding(new Insets(10));

        VBox buttonbox = new VBox(10, button, button2);
        buttonbox.setPadding(new Insets(10));
        buttonbox.setAlignment(Pos.CENTER_LEFT);

        HBox hBox2 = new HBox(5, textField, textField2, button3, button4);
        hBox2.setPadding(new Insets(10));
        hBox2.setAlignment(Pos.BOTTOM_RIGHT);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox hBox3 = new HBox(10, buttonbox, spacer, hBox2);
        hBox3.setPadding(new Insets(10));
        hBox3.setAlignment(Pos.BOTTOM_LEFT);

        VBox layout = new VBox(5, label, hBox, hBox3);
        layout.setPadding(new Insets(15));
        Scene scene = new Scene(layout, 700, 500);
        stage.setScene(scene);
        stage.setTitle("Admin");
    }
    private static <T> TableColumn<T, String> createColumn(String title, String property) {
        TableColumn<T, String> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(property));
        return col;
    }

}