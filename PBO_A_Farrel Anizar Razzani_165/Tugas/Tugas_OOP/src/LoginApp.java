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
            Admin adminLogin = new Admin("Farrel Anizar Razzani","202410370110165","Admin165","Password165");
            adminLogin.Login();
        } else if (pilihan == 2) {
            Student studentLogin = new Student("Farrel Anizar Razzani","202410370110165");
            studentLogin.Login();
        }
        else{
            System.out.println("Pilihan invalid!");
        }
    }
}
