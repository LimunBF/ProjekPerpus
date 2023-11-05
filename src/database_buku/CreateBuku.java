package database_buku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateBuku {

    public static void createjudulbuku(Scanner scanner){
        try {
            Connection koneksi = BookDataConnector.getConnection();
            Statement st = koneksi.createStatement();
            System.out.println("Koneksi Berhasil.");

            System.out.print("Masukkan Judul Buku: ");
            String judulbuku = scanner.nextLine();

            String insertQuery = "INSERT INTO data_buku (Judul_Buku) VALUES (?)";
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
            Connection koneksi = BookDataConnector.getConnection();
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
                Connection koneksi = BookDataConnector.getConnection();
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
                Connection koneksi = BookDataConnector.getConnection();
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
//    public static void createInputbuku(Scanner scanner) {
//        try {
//            Connection koneksi = BookDataConnector.getConnection();
//            Statement st = koneksi.createStatement();
//            System.out.println("Koneksi Berhasil");
//
//            System.out.print("Masukkan Nama Lengkap Anda: ");
//            String judulbuku = scanner.nextLine();
//
//            System.out.print("Masukkan NIM Anda: ");
//            String pengarang = scanner.nextLine();
//
//            System.out.print("Masukkan Program Pendidikan/Jurusan Anda: ");
//            String penerbit = scanner.nextLine();
//
//            System.out.print("Masukkan Program Pendidikan/Jurusan Anda: ");
//            String tahunterbit = scanner.nextLine();
//
//            String insertQuery = "INSERT INTO data_buku (Judul_Buku, Pengarang, Penerbit, Tahun_terbit) VALUES (?, ?, ?, ?)";
//
//            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
//            preparedStatement.setString(2, judulbuku);
//            preparedStatement.setString(3, pengarang);
//            preparedStatement.setString(4, penerbit);
//            preparedStatement.setString(5, tahunterbit );
//            int rowCount = preparedStatement.executeUpdate();
//            if (rowCount > 0) {
//                System.out.println("Data berhasil dimasukkan ke dalam data buku.");
//            } else {
//                System.out.println("Data gagal dimasukkan ke dalam data buku.");
//            }
//            st.close();
//            preparedStatement.close();
//            koneksi.close();
//            System.out.println("\nKoneksi Ditutup.....");
//        } catch (ClassNotFoundException | SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
}
