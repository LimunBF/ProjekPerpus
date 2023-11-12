package database_buku;

import database_mahasiswa.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ChangeDataBook {

    private static void changeInputBuku(Scanner scanner) {
        try {
            Connection koneksi = BookDataConnector.getConnection();
            String updateQuery = "UPDATE data_buku SET Judul_Buku = ?, Pengarang = ?, Penerbit = ?, Tahun_terbit = ?  WHERE ID = ?";
            PreparedStatement preparedStatement = koneksi.prepareStatement(updateQuery);
            boolean success = false;

            while (!success) {
                System.out.println("Masukkan ID/Nama Buku yang ingin anda ubah");
                String input = scanner.nextLine();

                if (isNumeric(input)) {
                    int id = Integer.parseInt(input);

                    if (DatabaseConnector.doesIDBukuExist(koneksi, id)) {
                        updateData(scanner, preparedStatement, id);
                        success = true;
                    } else {
                        System.out.println("ID tidak ditemukan dalam database. Coba lagi.\n");
                        TimeUnit.SECONDS.sleep(5);
                    }
                } else {
                    String name = input;
                    int id = BookDataConnector.getBukuIDByNama(koneksi, name);

                    if (id != -1) {
                        updateData(scanner, preparedStatement, id);
                        success = true;
                    } else {
                        System.out.println("Nama buku tidak ditemukan dalam database. Coba lagi.\n");
                        TimeUnit.SECONDS.sleep(5);
                    }
                }
            }
            koneksi.close();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void updateData(Scanner scanner, PreparedStatement preparedStatement, int id) throws SQLException {
        System.out.println("Masukkan Judul Buku yang ingin anda ubah");
        String judulBuku = scanner.nextLine();
        System.out.println("Masukkan Pengarang yang ingin anda ubah");
        String pengarang = scanner.nextLine();
        System.out.println("Masukkan Penerbit yang ingin anda ubah");
        String penerbit = scanner.nextLine();
        System.out.println("Masukkan Tahun Terbit yang ingin anda ubah");
        int tahunTerbit = scanner.nextInt();
        scanner.nextLine();

        preparedStatement.setString(1, judulBuku);
        preparedStatement.setString(2, pengarang);
        preparedStatement.setString(3, penerbit);
        preparedStatement.setInt(4, tahunTerbit);
        preparedStatement.setInt(5, id);

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data Berhasil Diubah \n");
        } else {
            System.out.println("Gagal Mengubah Data. Coba Masukkan Perubahan Kembali.\n");
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
