package database_buku;

import static database_mahasiswa.DatabaseConnector.getConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDataConnector {

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

    public static boolean doesIDBukuExist(Connection connection, int id) throws SQLException {
        return checkIfIdBukuExists(connection, id);
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
    
    public static List<String> getTitleFromDatabase() throws ClassNotFoundException, SQLException {
        List<String> booktitle = new ArrayList<>();
        Connection connection = getConnection();

        String selectQuery = "SELECT DISTINCT Judul_Buku FROM data_buku";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String Judul = resultSet.getString("Judul_Buku");
                booktitle.add(Judul);
            }
        }
        connection.close();
        return booktitle;
    }

    public static int getBukuIDByNama(Connection connection, String Judul_Buku) throws SQLException {
        String query = "SELECT ID FROM data_buku WHERE Judul_Buku = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, Judul_Buku);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("ID");
                }
            }
        }
        return -1;
    }
}
