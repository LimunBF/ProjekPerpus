package database_buku;

import database_mahasiswa.DatabaseConnector;

import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Buku {

    public static void createInputbuku(Scanner scanner) {
        try {
            Connection koneksi = BookDataConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil");

            System.out.print("Masukkan Nama Lengkap Anda: ");
            String judulbuku = scanner.nextLine();

            System.out.print("Masukkan NIM Anda: ");
            String pengarang = scanner.nextLine();

            System.out.print("Masukkan Program Pendidikan/Jurusan Anda: ");
            String penerbit = scanner.nextLine();

            System.out.print("Masukkan Program Pendidikan/Jurusan Anda: ");
            String tahunterbit = scanner.nextLine();

            String insertQuery = "INSERT INTO data_buku (Judul_Buku, Pengarang, Penerbit, Tahun_terbit) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(2, judulbuku);
            preparedStatement.setString(3, pengarang);
            preparedStatement.setString(4, penerbit);
            preparedStatement.setString(5, tahunterbit );
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data berhasil dimasukkan ke dalam data buku.");
            } else {
                System.out.println("Data gagal dimasukkan ke dalam data buku.");
            }
            st.close();
            preparedStatement.close();
            koneksi.close();
            System.out.println("\nKoneksi Ditutup.....");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readInputbuku(Scanner scanner) {
        try {
            Connection koneksi = BookDataConnector.getConnection();
            Statement st = koneksi.createStatement();
            String query = " select *from data_buku";
            ResultSet rs = st.executeQuery(query);
            System.out.println("--------------------------------------------");
            System.out.println("[DATA BUKU]");
            while (rs.next()) {
                String id = rs.getString(1);
                String nama = rs.getString(2);
                String nim = rs.getString(3);
                String prodi = rs.getString(4);
                String output = id + " - " + nama + " - " + nim + " - " + prodi;
                System.out.println(output);
            }
            st.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void deleteInputBuku(Scanner scanner) {
        try {
            Connection koneksi = BookDataConnector.getConnection();
            String deletequery = "DELETE FROM mahasiswa WHERE id=?";
            PreparedStatement preparedStatement = koneksi.prepareStatement(deletequery);
            boolean success = false;

            while (!success) {
                System.out.println("Masukkan ID Yang Ingin Anda Hapus");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (DatabaseConnector.doesIDBukuExist(koneksi, id)) {
                    System.out.println("ID Tersebut Terdapat Di Dalam Database");
                    boolean validResponse = false;

                    while (!validResponse) {
                        System.out.println("Apakah Anda Ingin Menghapus Data Tersebut?");
                        System.out.println("Ketik: IYA atau TIDAK??");
                        String jawab = scanner.next();

                        if ("YA".equals(jawab)) {
                            preparedStatement.setInt(1, id);
                            System.out.println("Mulai Menghapus Data :");
                            System.out.println("--------------------------------------------");
                            int rowCount = preparedStatement.executeUpdate();
                            if (rowCount > 0) {
                                System.out.println("Data berhasil Dihapus Dari Tabel Mahasiswa.");
                                try {
                                    TimeUnit.SECONDS.sleep(2);
                                } catch (InterruptedException e) {
                                    System.err.println("Sleep interrupted: " + e.getMessage());
                                }
                                success = true;
                            } else {
                                System.out.println("Data Gagal Dihapus Dari Tabel Mahasiswa.");
                            }
                            validResponse = true;
                        } else if ("TIDAK".equals(jawab)) {
                            System.out.println("Baiklah Jika Anda Tidak Ingin Menghapus File Tersebut.");
                            try {
                                TimeUnit.SECONDS.sleep(2);
                            } catch (InterruptedException e) {
                                System.err.println("Sleep interrupted: " + e.getMessage());
                            }
                            return;
                        } else {
                            System.out.println("Jawaban Anda Tidak Valid, Silahkan Input Jawaban Yang Valid.");
                        }
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
            }
            preparedStatement.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void changeInputBuku (Scanner scanner) {
        try {
            Connection koneksi = BookDataConnector.getConnection();
            String updateQuery = "UPDATE mahasiswa SET Nama = ?, NIM = ?, Prodi = ? WHERE ID = ?";
            PreparedStatement preparedStatement = koneksi.prepareStatement(updateQuery);
            boolean success = false;

            while (!success) {
                System.out.println("Masukkan ID yang ingin anda ubah");
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
