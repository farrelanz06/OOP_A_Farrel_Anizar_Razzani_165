import java.time.LocalDateTime;//impor kelas untuk mengambil waktu sekarang
import java.util.Scanner;//impor kelas untuk mengambil input dari user

public class Codelab1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//objek untuk scannernya, system in digunakan untuk menerima input dari keyboard

        System.out.print("Masukkan nama : ");
        String nama = input.nextLine();//mengambil input nama user

        System.out.print("Masukkan jenis kelamin (P/L) : ");
        String kelamin = input.next();//mengambil input jenis kelamin user

        System.out.print("Masukkan tahun lahir : ");
        int TahunLahir = input.nextInt();//mengambil input tahun lahir user

        int TahunSekarang = LocalDateTime.now().getYear();//mengambil dan menyimpan tahun sekarang
        int umur = TahunSekarang - TahunLahir;//rumus menghitung umur user

        //untuk menentukan jenis kelamin, jika user menginput p maka kelaminnya adalah perempuan, jika user menginput l maka kelaminnya adalah laki laki
        if(kelamin.equals("P") || kelamin.equals("p")){
            kelamin = "Perempuan";
        }
        else if(kelamin.equals("L") || kelamin.equals("l")){
            kelamin = "Laki-laki";
        }
        else{
            kelamin = "invalid";
        }

        //print out hasil data diri user
        System.out.println("\nData Diri :");
        System.out.println("Nama : " + nama);
        System.out.println("Jenis Kelamin : " + kelamin);
        System.out.println("umur : " + umur);



    }
}


