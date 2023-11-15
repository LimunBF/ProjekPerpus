/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_mahasiswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Limun
 */
public class DeleteAnggota {
    public static void deleteDataAnggota(String nama, String nim, String fakultas, String prodi) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();

            // Modify the DELETE query based on your database schema
            String deleteQuery = "DELETE FROM anggota_perpus WHERE Nama = ? AND Nim = ? AND Fakultas = ? AND Prodi = ?";
            PreparedStatement preparedStatement = koneksi.prepareStatement(deleteQuery);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, nim);
            preparedStatement.setString(3, fakultas);
            preparedStatement.setString(4, prodi);

            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data anggota berhasil dihapus dari database.");
            } else {
                System.out.println("Data anggota tidak ditemukan atau gagal dihapus dari database.");
            }

            preparedStatement.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
