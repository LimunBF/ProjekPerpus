package database_mahasiswa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReadAnggotaPerpus {
    private static void readAnggotaPerpus(Scanner scanner) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            String query = " select *from anggota_perpus";
            ResultSet rs = st.executeQuery(query);
            System.out.println("--------------------------------------------");
            System.out.println("[DATA Anggota]");
            while (rs.next()) {
                String id = rs.getString(1);
                String Nama = rs.getString(2);
                String NIM = rs.getString(3);
                String Prodi = rs.getString(4);
                String Fakultas = rs.getString(5);
                String stats_peminjaman = rs.getString(6);
                String buku_yg_dipinjam = rs.getString(7);
                String tanggal_peminjaman = rs.getString(8);
                String tanggal_pengembalian = rs.getString(9);
                String sisa_waktu = rs.getString(10);
                String output = id + " - " + Nama + " - " + NIM + " - " + Prodi+ " - "+ Fakultas + " - " + stats_peminjaman + " - " + buku_yg_dipinjam+ " - " + tanggal_peminjaman + " - " + tanggal_pengembalian + " - " + sisa_waktu;
                System.out.println(output);
            }
            st.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
