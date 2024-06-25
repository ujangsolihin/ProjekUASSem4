package projekuaspbosem4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu Utama:");
            System.out.println("1. Tambah Obat");
            System.out.println("2. Tambah Pelanggan");
            System.out.println("3. Buat Transaksi");
            System.out.println("4. Lihat Data Obat");
            System.out.println("5. Lihat Data Pelanggan");
            System.out.println("6. Lihat Data Transaksi");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (pilihan) {
                case 1:
                    tambahObat();
                    break;
                case 2:
                    tambahPelanggan();
                    break;
                case 3:
                    buatTransaksi();
                    break;
                case 4:
                    lihatDataObat();
                    break;
                case 5:
                    lihatDataPelanggan();
                    break;
                case 6:
                    lihatDataTransaksi();
                    break;
                case 7:
                    System.out.println("Keluar...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahObat() {
        System.out.print("Nama Obat: ");
        String namaObat = scanner.nextLine();
        System.out.print("Jenis Obat: ");
        String jenisObat = scanner.nextLine();
        System.out.print("Harga: ");
        float harga = scanner.nextFloat();
        System.out.print("Stok: ");
        int stok = scanner.nextInt();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO obat (nama_obat, jenis_obat, harga, stok) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, namaObat);
            stmt.setString(2, jenisObat);
            stmt.setFloat(3, harga);
            stmt.setInt(4, stok);
            stmt.executeUpdate();
            System.out.println("Data obat berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void tambahPelanggan() {
        System.out.print("Nama Pelanggan: ");
        String namaPelanggan = scanner.nextLine();
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("No Telepon: ");
        String noTelepon = scanner.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO pelanggan (nama_pelanggan, alamat, no_telepon) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, namaPelanggan);
            stmt.setString(2, alamat);
            stmt.setString(3, noTelepon);
            stmt.executeUpdate();
            System.out.println("Data pelanggan berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void buatTransaksi() {
        System.out.print("ID Pelanggan: ");
        int idPelanggan = scanner.nextInt();
        System.out.print("ID Obat: ");
        int idObat = scanner.nextInt();
        System.out.print("Jumlah: ");
        int jumlah = scanner.nextInt();

        Date tanggalTransaksi = new Date(new java.util.Date().getTime());

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO transaksi (id_pelanggan, id_obat, jumlah, tanggal_transaksi) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPelanggan);
            stmt.setInt(2, idObat);
            stmt.setInt(3, jumlah);
            stmt.setDate(4, tanggalTransaksi);
            stmt.executeUpdate();

            String updateStokSql = "UPDATE obat SET stok = stok - ? WHERE id_obat = ?";
            PreparedStatement updateStokStmt = conn.prepareStatement(updateStokSql);
            updateStokStmt.setInt(1, jumlah);
            updateStokStmt.setInt(2, idObat);
            updateStokStmt.executeUpdate();

            System.out.println("Transaksi berhasil dibuat.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void lihatDataObat() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM obat";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idObat = rs.getInt("id_obat");
                String namaObat = rs.getString("nama_obat");
                String jenisObat = rs.getString("jenis_obat");
                float harga = rs.getFloat("harga");
                int stok = rs.getInt("stok");
                System.out.println("ID: " + idObat + ", Nama: " + namaObat + ", Jenis: " + jenisObat + ", Harga: " + harga + ", Stok: " + stok);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void lihatDataPelanggan() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM pelanggan";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idPelanggan = rs.getInt("id_pelanggan");
                String namaPelanggan = rs.getString("nama_pelanggan");
                String alamat = rs.getString("alamat");
                String noTelepon = rs.getString("no_telepon");
                System.out.println("ID: " + idPelanggan + ", Nama: " + namaPelanggan + ", Alamat: " + alamat + ", No Telepon: " + noTelepon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void lihatDataTransaksi() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM transaksi";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idTransaksi = rs.getInt("id_transaksi");
                int idPelanggan = rs.getInt("id_pelanggan");
                int idObat = rs.getInt("id_obat");
                int jumlah = rs.getInt("jumlah");
                Date tanggalTransaksi = rs.getDate("tanggal_transaksi");
                System.out.println("ID Transaksi: " + idTransaksi + ", ID Pelanggan: " + idPelanggan + ", ID Obat: " + idObat + ", Jumlah: " + jumlah + ", Tanggal: " + tanggalTransaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
