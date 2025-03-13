import java.util.Scanner;

public class Student {
    private String username;
    private String ID;

    void login(){
        Scanner input2 = new Scanner(System.in);
        System.out.print("Masukkan Nama : ");
        username = input2.nextLine();

        System.out.print("Masukkan NIM : ");
        ID = input2.nextLine();

        if(username.equals("Farrel Anizar Razzani") && ID.equals("202410370110165")){
            System.out.println("Login Mahasiswa Berhasil!");
        }
        else{
            System.out.println("Login gagal! Nama atau NIM salah");
        }
    }
}
