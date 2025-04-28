package Perpustakaan;

public class Anggota implements Peminjaman{
    String nama;
    String id;

    public Anggota(String nama, String id){
        this.nama = nama;
        this.id = id;
    }

    public void displayinfo(){
        System.out.println("Anggota : " + nama + " (ID: " + id + ")");
    }

    @Override
    public void kembalikanBuku(Buku buku) {
        System.out.println(nama + " mengembalikan buku berjudul : " + buku.judul);
    }

    @Override
    public void pinjamBuku(Buku buku) {
        System.out.println(nama + " meminjam buku berjudul : " + buku.judul);
    }

    @Override
    public void pinjamBuku(Buku buku, int durasi) {
        System.out.println(nama + " meminjam buku berjudul : " + buku.judul + " selama " + durasi + " hari.");
    }
}
