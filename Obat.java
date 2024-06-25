/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekuaspbosem4;
public class Obat {
    private int idObat;
    private String namaObat;
    private String jenisObat;
    private float harga;
    private int stok;

    public Obat(int idObat, String namaObat, String jenisObat, float harga, int stok) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        this.jenisObat = jenisObat;
        this.harga = harga;
        this.stok = stok;
    }

    public int getIdObat() {
        return idObat;
    }

    public void setIdObat(int idObat) {
        this.idObat = idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getJenisObat() {
        return jenisObat;
    }

    public void setJenisObat(String jenisObat) {
        this.jenisObat = jenisObat;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "Obat{" +
                "idObat=" + idObat +
                ", namaObat='" + namaObat + '\'' +
                ", jenisObat='" + jenisObat + '\'' +
                ", harga=" + harga +
                ", stok=" + stok +
                '}';
    }
}
