/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_mahasiswa;

/**
 *
 * @author Limun
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class UpdateDatabase {

    private static final String url = "jdbc:mysql://your_database_host:your_database_port/your_database_name";
    private static final String username = "your_database_username";
    private static final String password = "your_database_password";

    public static void updateStatsPeminjaman(int recordId) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String updateStatsQuery = "UPDATE anggota_perpus SET stats_peminjaman = 'YES' WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateStatsQuery)) {
                preparedStatement.setInt(1, recordId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateStatsPengembalian(int recordId) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String updateStatsQuery = "UPDATE anggota_perpus SET stats_peminjaman = 'NO' WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateStatsQuery)) {
                preparedStatement.setInt(1, recordId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateTanggalPeminjamanAndSisaWaktu(int recordId) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String updateTanggalQuery = "UPDATE anggota_perpus SET tanggal_peminjaman = ?, sisa_waktu = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateTanggalQuery)) {
                // Set tanggal_peminjaman to current timestamp
                Date currentDate = new Date();
                Timestamp timestamp = new Timestamp(currentDate.getTime());
                preparedStatement.setTimestamp(1, timestamp);

                // Set sisa_waktu to 5 days from now
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);
                calendar.add(Calendar.DAY_OF_MONTH, 5);
                Timestamp sisaWaktuTimestamp = new Timestamp(calendar.getTime().getTime());
                preparedStatement.setTimestamp(2, sisaWaktuTimestamp);

                preparedStatement.setInt(3, recordId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updatePengembalianBuku(String judulBuku, String namaPeminjam) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Your update logic for returning a book
            // For example:
            String updateAnggotaQuery = "UPDATE anggota_perpus SET status_peminjaman = 'NO' WHERE Nama = ? AND status_peminjaman = 'YES'";
            try (PreparedStatement preparedStatementAnggota = connection.prepareStatement(updateAnggotaQuery)) {
                preparedStatementAnggota.setString(1, namaPeminjam);
                preparedStatementAnggota.executeUpdate();
            }

            // Additional logic if needed
        }
    }

    public static void updateStatusPinjam(String judulBuku, String newStatus) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Your update logic for updating the status of borrowing
            // For example:
            String updateBukuQuery = "UPDATE data_buku SET status_pinjam = ? WHERE judul = ? AND status_pinjam = 'YES'";
            try (PreparedStatement preparedStatementBuku = connection.prepareStatement(updateBukuQuery)) {
                preparedStatementBuku.setString(1, newStatus);
                preparedStatementBuku.setString(2, judulBuku);
                preparedStatementBuku.executeUpdate();
            }

            // Additional logic if needed
        }
    }
}

