package database_buku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateBuku {
    public static void CreateDataBuku(String judul, String pengarang, String penerbit, String tahunterbit) {
        try {
            Connection koneksi = BookDataConnector.getConnection();

            String insertQuery = "INSERT INTO data_buku (Judul_Buku, Pengarang, Penerbit, Tahun_terbit) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(1, judul);
            preparedStatement.setString(2, pengarang);
            preparedStatement.setString(3, penerbit);
            preparedStatement.setString(4, tahunterbit);

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
