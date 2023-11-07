package database_buku;

import database_mahasiswa.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ChangeDataBook {
    private static void changeInputBuku (Scanner scanner) {
        try {
            Connection koneksi = BookDataConnector.getConnection();
            String updateQuery = "UPDATE data_buku SET Judul_Buku = ?, Pengarang = ?, Penerbit = ?, Tahun_terbit = ?  WHERE ID = ?";
            PreparedStatement preparedStatement = koneksi.prepareStatement(updateQuery);
            boolean success = false;

            while (!success) {
                System.out.println("Masukkan ID/Nama Buku yang ingin anda ubah");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (DatabaseConnector.doesIDBukuExist(koneksi, id)) {
                    System.out.println("Masukkan Nama yang ingin anda ubah");
                    String nama = scanner.nextLine();
                    System.out.println("Masukkan NIM yang ingin anda ubah");
                    String nim = scanner.nextLine();
                    System.out.println("Masukkan Prodi yang ingin anda ubah");
                    String prodi = scanner.nextLine();

                    preparedStatement.setString(1, nama);
                    preparedStatement.setString(2, nim);
                    preparedStatement.setString(3, prodi);
                    preparedStatement.setInt(4, id);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Data Berhasil Diubah \n");
                        success = true;
                    } else {
                        System.out.println("Gagal Mengubah Data. Coba Masukkan Perubahan Kembali.\n");
                    }
                } else {
                    System.out.println("ID tidak ditemukan dalam database. Coba lagi.\n");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        System.err.println("Sleep interrupted: " + e.getMessage());
                    }
                    return;
                }
                koneksi.close();
                preparedStatement.close();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
