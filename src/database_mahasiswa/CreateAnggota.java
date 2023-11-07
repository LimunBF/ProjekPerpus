package database_mahasiswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateAnggota {
    public static void createDataAnggota(Scanner scanner){
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil.");

            System.out.print("Masukkan Nama Anda: ");
            String judulbuku = scanner.nextLine();

            String insertQuery = "INSERT INTO anggota_perpus (Nama) VALUES (?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(2, judulbuku);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data judul berhasil dimasukkan ke dalam data buku.");
            } else {
                System.out.println("Data judul gagal dimasukkan ke dalam data buku.");
            }
            st.close();
            preparedStatement.close();
            koneksi.close();
            System.out.println("\nKoneksi Ditutup.....");
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createpengarangtbuku(Scanner scanner) {
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil.");

            System.out.print("Masukkan Pengarang Buku: ");
            String pengarangbuku = scanner.nextLine();

            String insertQuery = "INSERT INTO data_buku (Pengarang) VALUES (?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(3, pengarangbuku);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data judul berhasil dimasukkan ke dalam data buku.");
            } else {
                System.out.println("Data judul gagal dimasukkan ke dalam data buku.");
            }
            st.close();
            preparedStatement.close();
            koneksi.close();
            System.out.println("\nKoneksi Ditutup.....");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createpenerbittbuku (Scanner scanner){
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil.");

            System.out.print("Masukkan Penerbit Buku: ");
            String penerbitbuku = scanner.nextLine();

            String insertQuery = "INSERT INTO data_buku (Penerbit) VALUES (?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(4, penerbitbuku);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data judul berhasil dimasukkan ke dalam data buku.");
            } else {
                System.out.println("Data judul gagal dimasukkan ke dalam data buku.");
            }
            st.close();
            preparedStatement.close();
            koneksi.close();
            System.out.println("\nKoneksi Ditutup.....");
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createtahunterbitbuku (Scanner scanner){
        try {
            Connection koneksi = DatabaseConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil.");

            System.out.print("Masukkan Tahun Terbit Buku: ");
            String tahunterbit = scanner.nextLine();

            String insertQuery = "INSERT INTO data_buku (Tahun_terbit) VALUES (?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(5, tahunterbit);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data judul berhasil dimasukkan ke dalam data buku.");
            } else {
                System.out.println("Data judul gagal dimasukkan ke dalam data buku.");
            }
            st.close();
            preparedStatement.close();
            koneksi.close();
            System.out.println("\nKoneksi Ditutup.....");
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
