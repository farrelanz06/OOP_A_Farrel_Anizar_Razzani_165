import java.util.Scanner;//impor kelas untuk mengambil input dari user

public class Tugas1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//objek scanner untuk mengambil input dan system in mengambil input dari keyboard user

        //menu pilihan login
        System.out.println("Piih login :");
        System.out.println("1. Admin\n2. Mahasiswa");
        System.out.print("Masukkan pilihan : ");
        int pilihan = input.nextInt();//mengambil input pilihan dari user

        input.nextLine();//untuk menghapus buffer yang tertinggal dari input integer, jika tidak pakai maka proses selanjutnya dibagian input nexline akan error

        //kondisi untuk menentukan pilihan user, jika masukkan angka 1 maka masuk ke tampilan login admin, jika yang dimasukkan angka 2 maka masuk ke tampilan login mahasiswa
        if(pilihan == 1){//jika pilihan user adalah admin
            System.out.print("Masukkan username : ");
            String username = input.nextLine();//mengambil input username user

            System.out.print("Masukkan password : ");
            String password = input.nextLine();//mengambil input password user

            //melihat kondisi apakah username dan password yang dimasukkan sama
            if(username.equals("Admin165") && password.equals("Password165")){
                System.out.println("Login Admin berhasil!");
            }
            else{
                System.out.println("Login gagal! Username atau password salah");
            }
        }
        else if(pilihan == 2) {//jika pilihan user adalah mahasiswa
            System.out.print("Masukkan nama : ");
            String nama = input.nextLine();//mengambil input nama user
            System.out.print("Masukkan NIM : ");
            String nim = input.nextLine();//mengambil input nim user

            //melihat kondisi apakah nama dan nim yang dimasukkan sama
            if (nama.equals("Farrel Anizar Razzani") && nim.equals("202410370110165")){
                System.out.println("Login Mahasiswa berhasil!");
            }
            else{
                System.out.println("Login gagal! Nama atau NIM salah");
            }

        }
        else{
            System.out.println("Pilihan tidak valid");
        }
    }
}
