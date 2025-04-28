package App;

import Perpustakaan.Anggota;
import Perpustakaan.Fiksi;
import Perpustakaan.NonFiksi;

public class Main {
    public static void main(String[] args) {
        Fiksi fiksi = new Fiksi("Bumi Manusia", "Pramoedya Ananta Toer");
        NonFiksi nonFiksi = new NonFiksi("Atomic Habits", "James Clear");

        Anggota anggota1 = new Anggota("Farrel", "A165");
        Anggota anggota2 = new Anggota("Diandra", "A024");

        fiksi.displayinfo();
        nonFiksi.displayinfo();
        System.out.println();
        anggota1.displayinfo();
        anggota2.displayinfo();
        System.out.println();
        anggota1.pinjamBuku(fiksi);
        anggota2.pinjamBuku(nonFiksi, 7);
        System.out.println();
        anggota1.kembalikanBuku(fiksi);
        anggota2.kembalikanBuku(nonFiksi);
    }
}
