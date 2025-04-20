import java.util.Scanner;

public class Student extends UserClass {
    Student(String name,String id){
        super(name, id);
    }

    @Override
    void Login() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Nama : ");
        setName(input.nextLine());

        System.out.print("Masukkan NIM : ");
        setId(input.nextLine());

        if(getName().equals("Farrel Anizar Razzani") && getId().equals("202410370110165")){
            System.out.println("\nLogin Mahasiswa Berhasil!");
            DisplayInfo();
        }
        else{
            System.out.println("Login gagal! Nama atau NIM salah");
        }
    }

    @Override
    void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Account type : Student");
    }
}
