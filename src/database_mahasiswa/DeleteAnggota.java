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

            String insertQuery = "DELETE FROM anggota_perpus (Nama, Nim, Fakultas, Prodi) VALUES (?, ?, ?, ?)";
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
