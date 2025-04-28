package Perpustakaan;

public class Fiksi extends Buku{
    public Fiksi(String judul, String penulis){
        super(judul,penulis);
    }

    @Override
    public void displayinfo() {
        System.out.println("Buku Fiksi : " + judul + " Oleh " + penulis);
    }
}
