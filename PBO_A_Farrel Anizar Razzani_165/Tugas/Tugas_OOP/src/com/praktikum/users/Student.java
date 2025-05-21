package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Student extends UserClass implements MahasiswaActions {
    Scanner input = new Scanner(System.in);
    public Student(String name,String id){
        super(name, id);
    }

    @Override
    public void Login() {
        System.out.println("Login Mahasiswa berhasil!");
        DisplayInfo();
    }

    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Account type : Student");
    }

    @Override
    public void viewReportedItems() {
       if(LoginSystem.reportedItems.isEmpty()){
           System.out.println("Belum ada laporan barang");
       }
       else {
           Iterator<Item> iterator = LoginSystem.reportedItems.iterator();
           boolean adaLaporan = false;
           while(iterator.hasNext()){
                Item item = iterator.next();
               if("Reported".equals(item.getStatus())){
                   System.out.println("Nama barang : " + item.getItemName());
                   System.out.println("Deskripsi barang : " + item.getDescription());
                   System.out.println("Lokasi barang : " + item.getLocation());
                   System.out.println("=================================");
                   adaLaporan = true;
               }
           }
           if(!adaLaporan){
               System.out.println("Belum ada laporan");
           }
       }
    }

    @Override
    public void reportItem() {
        System.out.println("Data Kehilangan Barang :");
        System.out.print("1. Nama Barang : ");
        String namaBarang = input.nextLine();
        System.out.print("2. Deskripsi Barang : ");
        String deskripsiBarang = input.nextLine();
        System.out.print("3. Lokasi Terakhir/Ditemukan : ");
        String lokasiTerakhir = input.nextLine();

        Item itemBaru = new Item(namaBarang, deskripsiBarang, lokasiTerakhir, "Reported");

        LoginSystem.reportedItems.add(itemBaru);

        System.out.println("Laporan barang berhasil ditambahkan");

    }

    @Override
    public void DisplayAppMenu() {
        while(true) {
            System.out.println("\nMENU :\n1. Laporkan Barang Temuan/Hilang\n2. Lihat Daftar Laporan\n0. Keluar");
            System.out.print("Masukkan pilihan(0/1/2) : ");

            try {
                int pilihan = input.nextInt();
                input.nextLine();

                switch (pilihan) {
                    case 1:
                        reportItem();
                        break;
                    case 2:
                        viewReportedItems();
                        break;
                    case 0:
                        System.out.println("Anda logout!");
                        return;
                    default:
                        System.out.println("Invalid");
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Input harus berupa angka!");
                input.nextLine();
            }
        }
    }
}

