package database_mahasiswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InputNewAnggotaPerpus {
    public static void NewnamaAnggota(Scanner scanner) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil.");

            System.out.print("Masukkan Nama Anda Lengkap Anda : ");
            String namaanggota = scanner.nextLine();

            String insertQuery = "INSERT INTO anggota_perpus (Nama) VALUES (?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(2, namaanggota);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data Nama berhasil dimasukkan ke dalam data Anggota.");
            } else {
                System.out.println("Data Nama gagal dimasukkan ke dalam data Anggota.");
            }
            st.close();
            preparedStatement.close();
            koneksi.close();
            System.out.println("\nKoneksi Ditutup.....");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void newNIManggota(Scanner scanner) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil.");

            System.out.print("Masukkan NIM Anda : " );
            String nimMHS = scanner.nextLine();

            String insertQuery = "INSERT INTO anggota_perpus (NIM) VALUES (?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(3, nimMHS);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data NIM berhasil dimasukkan ke dalam data Anggota");
            } else {
                System.out.println("Data NIM gagal dimasukkan ke dalam data Anggota.");
            }
            st.close();
            preparedStatement.close();
            koneksi.close();
            System.out.println("\nKoneksi Ditutup.....");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void newProdianggota(Scanner scanner) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil.");

            System.out.print("Masukkan Prodi Asal Anda : ");
            String prodiMHS = scanner.nextLine();

            String insertQuery = "INSERT INTO anggota_perpus (Prodi) VALUES (?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(4, prodiMHS);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data Prodi berhasil dimasukkan ke dalam data Anggota.");
            } else {
                System.out.println("Data Prodi gagal dimasukkan ke dalam data Anggota.");
            }
            st.close();
            preparedStatement.close();
            koneksi.close();
            System.out.println("\nKoneksi Ditutup.....");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void newFakultasanggota(Scanner scanner) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil.");

            System.out.print("Masukkan Fakultas Asal Anda : ");
            String fakultasMHS = scanner.nextLine();

            String insertQuery = "INSERT INTO anggota_perpus (Fakultas) VALUES (?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(5, fakultasMHS);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data Fakultas berhasil dimasukkan ke dalam data Anggota.");
            } else {
                System.out.println("Data Fakultas gagal dimasukkan ke dalam data Anggota.");
            }
            st.close();
            preparedStatement.close();
            koneksi.close();
            System.out.println("\nKoneksi Ditutup.....");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void makePasswordAnggota(Scanner scanner) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil.");

            System.out.print("Masukkan password yang kamu inginkan: ");
            String paswrd = scanner.nextLine();

            String insertQuery = "INSERT INTO data_buku (password) VALUES (?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(5, paswrd);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data Password berhasil dimasukkan ke dalam data Anggota.");
            } else {
                System.out.println("Data Password gagal dimasukkan ke dalam data Anggota.");
            }
            st.close();
            preparedStatement.close();
            koneksi.close();
            System.out.println("\nKoneksi Ditutup.....");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
