package database_admin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateAdmin {
    public static void createUserAdmin(Scanner scanner){
        try {
            Connection koneksi = AdminConnector.getConnection();
            Statement st = koneksi.createStatement();

            System.out.print("Masukkan Nama Anda: ");
            String username = scanner.nextLine();

            String insertQuery = "INSERT INTO data_admin (username) VALUES (?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            st.close();
            preparedStatement.close();
            koneksi.close();
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void cratepswrdadmin(Scanner scanner){
        try {
            Connection koneksi = AdminConnector.getConnection();
            Statement st = koneksi.createStatement();

            System.out.print("Masukkan Nama Anda: ");
            String password = scanner.nextLine();

            String insertQuery = "INSERT INTO data_admin (password) VALUES (?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            st.close();
            preparedStatement.close();
            koneksi.close();
        }
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
