package database_mahasiswa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import frame.DataAnggota;
import java.util.ArrayList;
import java.util.List;

public class ReadAnggotaPerpus extends DataAnggota{
 
      public static List<String[]> readAnggotaPerpus(Scanner scanner) {
        List<String[]> anggotaList = new ArrayList<>();

        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            String query = "SELECT * FROM anggota_perpus";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String[] anggota = new String[10];
                anggota[0] = rs.getString(1); // id
                anggota[1] = rs.getString(2); // Nama
                anggota[2] = rs.getString(3); // NIM
                anggota[3] = rs.getString(4); // Prodi
                anggota[4] = rs.getString(5); // Fakultas
                anggota[5] = rs.getString(6); // stats_peminjaman
                anggota[6] = rs.getString(7); // buku_yg_dipinjam
                anggota[7] = rs.getString(8); // tanggal_peminjaman
                anggota[8] = rs.getString(9); // tanggal_pengembalian
                anggota[9] = rs.getString(10); // sisa_waktu

                anggotaList.add(anggota);
            }
            st.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return anggotaList;
    }
}
