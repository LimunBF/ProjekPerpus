package database_mahasiswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateAnggota {
    public static void createDataAnggota(String nama, String nim, String fakultas, String prodi) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            
            String insertQuery = "INSERT INTO anggota_perpus (Nama, Nim, Fakultas, Prodi) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, nim);
            preparedStatement.setString(3, fakultas);
            preparedStatement.setString(4, prodi);

            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data anggota berhasil dimasukkan ke dalam database.");
            } else {
                System.out.println("Data anggota gagal dimasukkan ke dalam database.");
            }

            preparedStatement.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
