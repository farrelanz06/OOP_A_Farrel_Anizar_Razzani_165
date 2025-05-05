package com.praktikum.users;

import com.praktikum.actions.AdminActions;

import java.util.Scanner;

public class Admin extends UserClass implements AdminActions {
    private String username;
    private String password;
    Scanner input = new Scanner(System.in);

    public Admin(String name, String id, String username, String password) {
        super(name, id);
        this.username = username;
        this.password = password;
    }

    @Override
    public void Login() {
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
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Account type : Admin");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }

    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void DisplayAppMenu() {

        while(true) {
            System.out.println("\nMENU :\n1. Kelola Laporan Barang\n2. Kelola Data Mahasiswa\n0. Logout");
            System.out.print("Masukkan Pilihan(0/1/2) : ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    manageItems();
                    break;

                case 2:
                    manageUsers();
                    break;

                case 0:
                    System.out.println("Anda Logout");
                    return;

                default:
                    System.out.println("Invalid!");
                    break;
            }
        }
    }
}

