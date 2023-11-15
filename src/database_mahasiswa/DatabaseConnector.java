package database_mahasiswa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {

    private static String url = "jdbc:mysql://localhost:3306/projek_perpus";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
    private static boolean checkIfIdBukuExists(Connection connection, int id) throws SQLException {
        String checkQuery = "SELECT COUNT(*) FROM data_buku WHERE id = ?";
        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
        checkStatement.setInt(1, id);
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        return count > 0;
    }

    //    public static boolean checkifUsernameExist(Connection connection, int username) throws SQLException{
//        String checkQuery = "SELECT COUNT(*) FROM mahasiswa WHERE Username = ?";
//        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
//        checkStatement.setInt(1, Username);
//        ResultSet resultSet = checkStatement.executeQuery();
//        resultSet.next();
//        int count = resultSet.getInt(1);
//        return count > 0;
//    }

    public static boolean doesIDBukuExist(Connection connection, int id) throws SQLException {
        return checkIfIdBukuExists(connection, id);
    }
//    public static boolean doesUserexist(Connection connection, String username) throws SQLException{
//        return checkifUsernameExist(connection, Username);
//    }

        public static List<String> getNamesFromDatabase() throws ClassNotFoundException, SQLException {
        List<String> names = new ArrayList<>();
        Connection connection = getConnection();

        // Modify the SELECT query based on your database schema
        String selectQuery = "SELECT DISTINCT Nama FROM anggota_perpus";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("Nama");
                names.add(name);
            }
        }

        connection.close();
        return names;
    }
    
    public static boolean deleteBookByName(Connection connection, String bookName) {
        try {
            String deleteQuery = "DELETE FROM data_buku WHERE Judul_Buku =  ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, bookName.trim());

            int rowCount = preparedStatement.executeUpdate();

            preparedStatement.close();

            return rowCount > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting book by name: " + e.getMessage());
            return false;
        }
    }
}
