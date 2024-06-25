/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekuaspbosem4;
import java.util.Date;

public class Transaksi {
    private int idTransaksi;
    private int idPelanggan;
    private int idObat;
    private int jumlah;
    private Date tanggalTransaksi;

    public Transaksi(int idTransaksi, int idPelanggan, int idObat, int jumlah, Date tanggalTransaksi) {
        this.idTransaksi = idTransaksi;
        this.idPelanggan = idPelanggan;
        this.idObat = idObat;
        this.jumlah = jumlah;
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public int getIdObat() {
        return idObat;
    }

    public void setIdObat(int idObat) {
        this.idObat = idObat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "idTransaksi=" + idTransaksi +
                ", idPelanggan=" + idPelanggan +
                ", idObat=" + idObat +
                ", jumlah=" + jumlah +
                ", tanggalTransaksi=" + tanggalTransaksi +
                '}';
    }
}
