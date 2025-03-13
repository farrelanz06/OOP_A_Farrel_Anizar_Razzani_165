import java.util.Scanner;

public class LoginApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilih Login");
        System.out.println("1. Admin\n2. Mahasiswa");
        System.out.print("Masukkan Pilihan : ");
        int pilihan = input.nextInt();

        input.nextLine();

        if(pilihan == 1){
            Admin adminLogin = new Admin();
            adminLogin.Login();
        }
        else if(pilihan == 2){
            Student studentLogin = new Student();
            studentLogin.login();
        }
        else{
            System.out.println("Pilihan Invalid!");
        }
    }
}