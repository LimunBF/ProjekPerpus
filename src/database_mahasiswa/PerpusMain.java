package database_mahasiswa;

import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PerpusMain {
    void inputUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===============================");
            System.out.println("[SELAMAT DATANG DI PERPUS PUSAT UNS]");
            System.out.println("1. Pendaftaran Anggota");
            System.out.println("2. Tampilkan Data Anggota");
            System.out.println("3. Ubah Data Anggota");
            System.out.println("4. Hapus Data Anggota");
            System.out.println("5. Keluar");
            System.out.println("===============================");
            System.out.print("Masukkan perintah: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    createDatabase(scanner);
                }
                case 2 -> {
                    readDatabase(scanner);
                }
                case 3 -> {
                    ubahdata(scanner);
                }
                case 4 -> {
                    deletedatabase(scanner);
                }
                case 5 -> {
                    System.out.println("Sampai Jumpa!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Perintah tidak valid. Silahkan Masukan Perintah lagi.");
            }
        }
    }

    public static void createDatabase(Scanner scanner) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil");

            System.out.print("Masukkan Nama Lengkap Anda: ");
            String namamhs = scanner.nextLine();

            System.out.print("Masukkan NIM Anda: ");
            String nimmhs = scanner.nextLine();

            System.out.print("Masukkan Program Pendidikan/Jurusan Anda: ");
            String prodimhs = scanner.nextLine();

            String insertQuery = "INSERT INTO mahasiswa (Nama, NIM, Prodi) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(1, namamhs);
            preparedStatement.setString(2, nimmhs);
            preparedStatement.setString(3, prodimhs);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data berhasil dimasukkan ke dalam tabel mahasiswa.");
            } else {
                System.out.println("Data gagal dimasukkan ke dalam tabel mahasiswa.");
            }
            st.close();
            preparedStatement.close();
            koneksi.close();
            System.out.println("\nKoneksi Ditutup.....");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readDatabase(Scanner scanner) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            String query = " select *from mahasiswa";
            ResultSet rs = st.executeQuery(query);
            System.out.println("--------------------------------------------");
            System.out.println("[DATA ANGGOTA]");
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

    private static void deletedatabase(Scanner scanner) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            String deletequery = "DELETE FROM mahasiswa WHERE id=?";
            PreparedStatement preparedStatement = koneksi.prepareStatement(deletequery);
            boolean success = false;

            while (!success) {
                System.out.println("Masukkan ID Yang Ingin Anda Hapus");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (DatabaseConnector.doesIdExist(koneksi, id)) {
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

    private static void ubahdata(Scanner scanner) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            String updateQuery = "UPDATE mahasiswa SET Nama = ?, NIM = ?, Prodi = ? WHERE ID = ?";
            PreparedStatement preparedStatement = koneksi.prepareStatement(updateQuery);
            boolean success = false;

            while (!success) {
                System.out.println("Masukkan ID yang ingin anda ubah");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (DatabaseConnector.doesIdExist(koneksi, id)) {
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
