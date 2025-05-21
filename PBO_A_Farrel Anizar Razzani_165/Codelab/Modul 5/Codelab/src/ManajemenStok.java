import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("====MANAJEMEN STOK BARANG====");
            System.out.println("\n1.Tambah barang baru\n2.Tampilkan semua barang\n3.Kurangi stok barang\n4.Keluar");
            System.out.print("Pilih : ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang : ");
                    String nama = input.nextLine();

                    try {
                        System.out.print("Masukkan stok awal : ");
                        int stok = input.nextInt();
                        if(stok > 0) {
                            daftarBarang.add(new Barang(nama, stok));
                        }
                        else{
                            System.out.println("Tidak boleh stok 0\n");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error! Harap masukkan angka");
                        input.nextLine();
                    }
                    break;
                case 2:
                    System.out.println("====Daftar Barang====");
                    if(daftarBarang.isEmpty()){
                        System.out.println("Stok barang kosong\n");
                    }
                    else {
                        Iterator<Barang> iterator = daftarBarang.iterator();
                        int index = 1;
                        while (iterator.hasNext()) {
                            Barang barang = iterator.next();
                            System.out.println(index + ". Nama : " + barang.getNama() + "  Stok : " + barang.getStok());
                            index++;
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("====Daftar Barang====");
                    for(int i = 0; i < daftarBarang.size(); i++){
                        Barang barang = daftarBarang.get(i);
                        System.out.println((i+1) + ". " + barang.getNama() + " (" + barang.getStok() + " Stok)" );
                    }

                    try{
                        System.out.print("Masukkan nomor barang yang ingin dikurangi stoknya : ");
                        int indeksStok = input.nextInt() - 1;
                        Barang barang = daftarBarang.get(indeksStok);

                        System.out.print("Masukkan jumlah stok yang ingin dikurangi : ");
                        int jumlahStok = input.nextInt();

                        if (jumlahStok > barang.getStok()) {
                            throw new StokTidakCukupException("Stok untuk '" + barang.getNama() + "' hanya " + barang.getStok());
                        }
                        barang.setStok(barang.getStok() - jumlahStok);
                        System.out.println("Stok barang " + " '" + barang.getNama() + "' berhasil dikurangi. Sisa stok " + barang.getStok());
                        System.out.println("");

                    }
                    catch (InputMismatchException e){
                        System.out.println("Error! harap masukkan angka");
                        System.out.println("");
                        input.nextLine();
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Error! indeks yang anda masukkan tidak ada");
                        System.out.println("");
                    }
                    catch (StokTidakCukupException e){
                        System.out.println("Error! " + e.getMessage());
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    input.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid");
            }
        }
    }
}
