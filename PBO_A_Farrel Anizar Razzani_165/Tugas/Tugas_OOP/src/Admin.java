import java.util.Scanner;

public class Admin extends UserClass {
    private String username;
    private String password;

    Admin(String name, String id, String username, String password) {
        super(name, id);
        this.username = username;
        this.password = password;
    }

    @Override
    void Login() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String inputUsername = input.nextLine();

        System.out.print("Masukkan password: ");
        String inputPassword = input.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("\nLogin Admin Berhasil!");
            DisplayInfo();
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    @Override
    void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Account type : Admin");
    }
}
