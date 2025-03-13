import java.util.Scanner;

class Admin {
    private String username;
    private String password;

    void Login (){
            Scanner input1 = new Scanner(System.in);
            System.out.print("Masukkan username : ");
            username = input1.nextLine();

            System.out.print("Masukkan password : ");
            password = input1.nextLine();

            if(username.equals("Admin165") && password.equals("Password165")){
                System.out.println("Login Admin Berhasil!");
            }
            else {
                System.out.println("Login gagal! username atau password salah");
            }
        }
    }

