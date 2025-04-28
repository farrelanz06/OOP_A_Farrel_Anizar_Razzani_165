package Perpustakaan;

public class NonFiksi extends Buku{
    public NonFiksi(String judul,String penulis){
        super(judul, penulis);
    }

    @Override
    public void displayinfo() {
        System.out.println("Buku Non-Fiksi : " + judul + " Oleh " + penulis);
    }
}
