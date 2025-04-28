package Perpustakaan;

public interface Peminjaman {
    public void pinjamBuku(Buku buku);
    public void pinjamBuku(Buku buku, int durasi);
    public void kembalikanBuku(Buku buku);
}
