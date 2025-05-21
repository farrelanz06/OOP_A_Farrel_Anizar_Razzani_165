package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Student;
import com.praktikum.users.UserClass;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<UserClass> userlist = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public void objectUser() {
        userlist.add(new Admin("Farrel Anizar Razzani", "202410370110165", "Admin165", "Password165"));
        userlist.add(new Student("Farrel Anizar Razzani","202410370110165"));
    }

    public UserClass login(Scanner input) {
        System.out.print("Masukkan Username : ");
        String Inputusername = input.nextLine();

        System.out.print("Masukkan Password : ");
        String Inputpassword = input.nextLine();

        for (int i = 0; i < userlist.size(); i++) {
            UserClass user = userlist.get(i);
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                if (admin.getUsername().equals(Inputusername) && admin.getPassword().equals(Inputpassword)) {
                    return admin;
                }
            } else if (user instanceof Student) {
                Student student = (Student) user;
                if (student.getName().equals(Inputusername) && student.getId().equals(Inputpassword)) {
                    return student;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LoginSystem system = new LoginSystem();
        system.objectUser();

        while (true) {
            System.out.println("\n===== SELAMAT DATANG =====");
            System.out.println("Pilih Login:");
            System.out.println("\u001B[33m1. Admin\n2. Mahasiswa\n0. Keluar\u001B[0m");
            System.out.print("Masukkan Pilihan: ");

            int pilihan;
            try {
                pilihan = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                continue;
            }


            switch (pilihan) {
                case 1:
                    UserClass user = system.login(input);
                    if (user != null && user instanceof Admin) {
                        user.Login();
                        user.DisplayAppMenu();
                    } else {
                        System.out.println("Login gagal: Username/Password salah atau bukan Admin.");
                    }
                    break;
                case 2:
                    UserClass user2 = system.login(input);
                    if (user2 != null && user2 instanceof Student) {
                        user2.Login();
                        user2.DisplayAppMenu();
                    } else {
                        System.out.println("Login gagal: Username/Password salah atau bukan Mahasiswa.");
                    }
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    input.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
