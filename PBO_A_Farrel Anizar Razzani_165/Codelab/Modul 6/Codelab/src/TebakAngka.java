import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class TebakAngka extends Application {
    int angkapercobaan = 0;
    boolean gameselesai = false;
    int randomnum;

    @Override
    public void start(Stage stage) throws Exception {
        Random random = new Random();
        randomnum = random.nextInt(100) + 1;

        Label label = new Label("\uD83C\uDFAF Ayo tebak angka 1-100");
        label.setStyle("-fx-text-fill: #8C52FF; -fx-font-size: 24px; -fx-font-family: 'Georgia'; -fx-font-weight: bold;-fx-font-style: italic;");

        Label label1 = new Label("Masukkan tebakanmu!");
        label1.setStyle("-fx-text-fill: #9d9b9e; -fx-font-size: 16px;");

        Label label2 = new Label("Jumlah percobaan : " + angkapercobaan);
        label2.setStyle("-fx-text-fill: #760278; -fx-font-size: 14px; -fx-font-family: 'Georgia'; -fx-font-weight: bold;");

        TextField isitebakan = new TextField();

        Button tombol = new Button("\uD83C\uDFB2 Coba tebak!");
        tombol.setStyle("-fx-background-color: #41066b; -fx-text-fill: white;");

        tombol.setOnAction(e -> {

            if (gameselesai){
                randomnum = random.nextInt(100) + 1;
                angkapercobaan = 0;
                label1.setText("Masukkan tebakanmu!");
                label1.setStyle("-fx-text-fill: #9d9b9e; -fx-font-size: 16px;");
                label2.setText("Jumlah percobaan : " + angkapercobaan);
                tombol.setText("\uD83C\uDFB2 Coba tebak!");
                tombol.setStyle("-fx-background-color: #41066b; -fx-text-fill: white;");
                isitebakan.clear();
                gameselesai = false;
                return;
            }
            try {
                int angka = Integer.parseInt(isitebakan.getText());
                angkapercobaan++;
                label2.setText("Jumlah percobaan : " + angkapercobaan);

                if (angka > randomnum) {
                    label1.setText("⚠ Waduh kegedean!");
                    label1.setStyle("-fx-text-fill: #FC771F; -fx-font-size: 16px;");
                } else if (angka < randomnum) {
                    label1.setText("⚠ Kekecilan abangkuh");
                    label1.setStyle("-fx-text-fill: #FC771F; -fx-font-size: 16px;");
                } else {
                    label1.setText("✔ GG kamu benar mama mu pasti bangga");
                    label1.setStyle("-fx-text-fill: #038E1B; -fx-font-size: 16px;");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Selamat tebakan kamu benar");
                    alert.showAndWait();
                    tombol.setText("Main lagi");
                    tombol.setStyle("-fx-background-color: #274e9c; -fx-text-fill: white;");
                    gameselesai = true;
                }
                isitebakan.clear();
            }
            catch (NumberFormatException b){
                label1.setText("Masukkan angka yang valid!");
                label1.setStyle("-fx-text-fill: #9d9b9e; -fx-font-size: 16px;");

            }
        });

        HBox hBox = new HBox(10, isitebakan, tombol);
        hBox.setAlignment(Pos.CENTER);
        VBox layout = new VBox(15, label,label1,hBox,label2);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #13021f;");

        Scene scene = new Scene(layout,400,250);
        stage.setScene(scene);
        stage.setTitle("Permainan tebak angka");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
