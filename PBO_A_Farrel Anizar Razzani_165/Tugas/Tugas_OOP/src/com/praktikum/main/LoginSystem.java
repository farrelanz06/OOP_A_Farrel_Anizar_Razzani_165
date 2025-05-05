package com.praktikum.main;

import com.praktikum.users.Admin;
import com.praktikum.users.Student;
import com.praktikum.users.UserClass;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilih Login");
        System.out.println("1. Admin\n2. Mahasiswa");
        System.out.print("Masukkan Pilihan : ");
        int pilihan = input.nextInt();

        input.nextLine();

        if(pilihan == 1){
            UserClass adminLogin = new Admin("Farrel Anizar Razzani","202410370110165","Admin165","Password165");
            adminLogin.Login();
            adminLogin.DisplayAppMenu();
        } else if (pilihan == 2) {
            UserClass studentLogin = new Student("Farrel Anizar Razzani","202410370110165");
            studentLogin.Login();
            studentLogin.DisplayAppMenu();
        }
        else{
            System.out.println("Pilihan invalid!");
        }
    }
}
