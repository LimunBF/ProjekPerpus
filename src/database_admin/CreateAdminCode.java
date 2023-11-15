package database_admin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateAdminCode {
        public static void createDataAdmin(String username, String password) {
        try {
            Connection koneksi = AdminConnector.getConnection();

            String insertQuery = "INSERT INTO data_admin (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = koneksi.prepareStatement(insertQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Data anggota berhasil dimasukkan ke dalam database.");
            } else {
                System.out.println("Data anggota gagal dimasukkan ke dalam database.");
            }

            preparedStatement.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
