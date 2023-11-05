package database_buku;

import database_mahasiswa.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Deletebuku {
    public static boolean deleteBookById(Connection connection, int id) {
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM data_buku WHERE id=?")) {
                preparedStatement.setInt(1, id);
                int rowCount = preparedStatement.executeUpdate();
                return rowCount > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error deleting book by ID: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteBookByName(Connection connection, String bookName) {
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM data_buku WHERE Judul_Buku = ?")) {
                preparedStatement.setString(1, bookName.trim());
                int rowCount = preparedStatement.executeUpdate();
                return rowCount > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error deleting book by name: " + e.getMessage());
            return false;
        }
    }

    private static void handleResponse(Scanner scanner, Connection koneksi, int id) {
        boolean validResponse = false;

        while (!validResponse) {
            System.out.println("Apakah Anda Ingin Menghapus Data Tersebut?");
            System.out.println("Ketik: YA atau TIDAK??");
            String jawab = scanner.next();

            if ("YA".equals(jawab)) {
                boolean deleted = deleteBookById(koneksi, id);
                if (deleted) {
                    System.out.println("Data berhasil Dihapus Dari Tabel Buku.");
                } else {
                    System.out.println("Data Gagal Dihapus Dari Tabel Buku.");
                }
                validResponse = true;
            } else if ("TIDAK".equals(jawab)) {
                System.out.println("Baiklah Jika Anda Tidak Ingin Menghapus File Tersebut.");
                validResponse = true;
            } else {
                System.out.println("Jawaban Anda Tidak Valid, Silahkan Input Jawaban Yang Valid.");
            }
        }
    }

    private static void deleteInputBuku(Scanner scanner) {
        try (Connection koneksi = BookDataConnector.getConnection()) {
            boolean success = false;

            while (!success) {
                System.out.println("Masukkan ID/Nama Yang Ingin Anda Hapus");
                String userInput = scanner.nextLine().trim();

                if (userInput.matches("\\d+")) {
                    int id = Integer.parseInt(userInput);

                    if (BookDataConnector.doesIDBukuExist(koneksi, id)) {
                        System.out.println("ID Tersebut Terdapat Di Dalam Database");
                        handleResponse(scanner, koneksi, id);
                        success = true;
                    } else {
                        System.out.println("ID tidak ditemukan dalam database. Coba lagi.\n");
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            System.err.println("Sleep interrupted: " + e.getMessage());
                        }
                        return;
                    }
                } else {
                    boolean deleted = BookDataConnector.deleteBookByName(koneksi, userInput);
                    if (deleted) {
                        System.out.println("Buku berhasil dihapus dari Tabel Buku.");
                    } else {
                        System.out.println("Buku tidak ditemukan dalam database. Coba lagi.\n");
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            System.err.println("Sleep interrupted: " + e.getMessage());
                        }
                    }
                    success = true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        deleteInputBuku(scanner);
        scanner.close();
    }
}
