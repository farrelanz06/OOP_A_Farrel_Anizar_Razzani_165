package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;

import java.util.Scanner;

public class Student extends UserClass implements MahasiswaActions {
    Scanner input = new Scanner(System.in);
    public Student(String name,String id){
        super(name, id);
    }

    @Override
    public void Login() {
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
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Account type : Student");
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">>Fitur Lihat Laporan Belum Tersedia<<");
    }

    @Override
    public void reportItem() {
        input.nextLine();
        System.out.println("Data Kehilangan Barang :");
        System.out.print("1. Nama Barang : ");
        String namaBarang = input.nextLine();
        System.out.print("2. Deskripsi Barang : ");
        String deskripsiBarang = input.nextLine();
        System.out.print("3. Lokasi Terakhir/Ditemukan : ");
        String lokasiTerakhir = input.nextLine();

        System.out.println("Laporan anda diterima...");
    }

    @Override
    public void DisplayAppMenu() {
        while(true) {
            System.out.println("\nMENU :\n1. Laporkan Barang Temuan/Hilang\n2. Lihat Daftar Laporan\n0. Logout");
            System.out.print("Masukkan pilihan(0/1/2) : ");
            int pilihan = input.nextInt();

            switch (pilihan){
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Anda Logout");
                    return;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }
}

