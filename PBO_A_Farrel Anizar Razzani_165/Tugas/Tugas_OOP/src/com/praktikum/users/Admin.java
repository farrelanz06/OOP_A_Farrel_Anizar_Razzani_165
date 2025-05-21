package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import java.util.InputMismatchException;
import java.util.Iterator;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void Login() {
        System.out.println("Login admin berhasil!");
        DisplayInfo();
    }

    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Account type : Admin");
    }

    @Override
    public void manageUsers() {
        while(true) {
            System.out.println("1. Tambah Mahasiswa\n2. Hapus Mahasiswa\n3. Kembali");
            System.out.print("Pilih : ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan){
                case 1:
                    System.out.print("Masukkan nama : ");
                    String namaMhs = input.nextLine();
                    System.out.print("Masukkan NIM : ");
                    String nimMhs = input.nextLine();

                    Student mhsBaru = new Student(namaMhs,nimMhs);
                    LoginSystem.userlist.add(mhsBaru);
                    System.out.println("Mahasiswa berhasil ditambahkan");
                    break;
                case 2:
                    boolean adaMahasiswa = false;
                    for(int i = 0; i < LoginSystem.userlist.size();i++){
                        UserClass user = LoginSystem.userlist.get(i);
                        if(user instanceof Student){
                            System.out.println((i+1) + ". Nama : " + user.getName() + ", NIM : " + user.getId());
                            adaMahasiswa = true;
                        }
                    }
                    if(!adaMahasiswa){
                        System.out.println("Belum ada mahasiswa yang terdaftar!");
                        break;
                    }

                    System.out.print("Masukkan NIM mahasiswa yang ingin dihapus :");
                    String nimHapus = input.nextLine();
                    boolean ditemukan = false;

                    Iterator<UserClass>iterator = LoginSystem.userlist.iterator();
                    while (iterator.hasNext()){
                        UserClass user = iterator.next();
                        if(user instanceof Student && user.getId().equals(nimHapus)){
                            iterator.remove();
                            ditemukan = true;
                            System.out.println("Mahasiswa berhasil dihapus");
                            break;
                        }
                    }
                    if(!ditemukan){
                        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    @Override
    public void manageItems() {
        while (true) {
            System.out.println("1. Lihat semua laporan\n2.Tandai barang yang telah diambil(claimed)\n3. kembali");
            System.out.print("Pilih : ");
            int pilihan;

            try {
                pilihan = input.nextInt();
                input.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                continue;
            }


            switch (pilihan) {
                case 1:
                    if(LoginSystem.reportedItems.isEmpty()){
                        System.out.println("Belum ada laporan barang");
                    }
                    else {
                        System.out.println("====Daftar laporan barang====");
                        Iterator<Item> iterator = LoginSystem.reportedItems.iterator();
                        while(iterator.hasNext()){
                            Item item = iterator.next();
                            System.out.println("Nama: " + item.getItemName());
                            System.out.println("Deskripsi: " + item.getDescription());
                            System.out.println("Lokasi: " + item.getLocation());
                            System.out.println("Status: " + item.getStatus());
                            System.out.println("============================");
                        }
                    }
                    break;
                case 2:
                    if(LoginSystem.reportedItems.isEmpty()){
                        System.out.println("Belum ada laporan barang");
                    }
                    else {
                        System.out.println("=====Daftar laporan barang berstatus reported=====");
                        Iterator<Item> iterator1 = LoginSystem.reportedItems.iterator();
                        int index = 0;
                        while ((iterator1.hasNext())) {
                            Item item = iterator1.next();
                            if ("Reported".equals(item.getStatus())) {
                                System.out.println((index + 1) + " - Nama : " + item.getItemName() + ", Deskripsi : " + item.getDescription() + ", Lokasi : " + item.getLocation());
                            }
                            index++;
                        }
                        System.out.print("Masukkan indeks barang yang ingin ditandai claimed : ");

                        try {
                            int pilihIndeks = input.nextInt() - 1;
                            Item item = LoginSystem.reportedItems.get(pilihIndeks);

                            if (item.getStatus().equals("Reported")) {
                                item.setStatus("Claimed");
                                System.out.println("Barang berhasil ditandai sebagai 'Claimed'");
                            } else {
                                System.out.println("Barang ini sudah ditandai sebelumnya");
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Indeks tidak valid");
                        } catch (InputMismatchException e) {
                            System.out.println("Harap masukkan angka");
                            input.nextLine();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Kembali ke menu");
                    return;
                default:
                    System.out.println("Pilihan tidak valid");

            }

        }
    }

    @Override
    public void DisplayAppMenu() {
        while(true) {
            System.out.println("\nMENU :\n1. Kelola Laporan Barang\n2. Kelola Data Mahasiswa\n0. Keluar");
            System.out.print("Masukkan Pilihan(0/1/2) : ");

            try {
                int pilihan = input.nextInt();

                switch (pilihan) {
                    case 1:
                        manageItems();
                        break;

                    case 2:
                        manageUsers();
                        break;

                    case 0:
                        System.out.println("Anda logout!");
                        return;
                    default:
                        System.out.println("Invalid!");
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

