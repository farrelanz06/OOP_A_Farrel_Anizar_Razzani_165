public class Barang {
    private String nama;
    private int stok;

    Barang(String nama, int stok){
        this.nama = nama;
        this.stok = stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }
}
