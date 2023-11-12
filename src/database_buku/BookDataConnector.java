package database_buku;

import java.sql.*;

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

//        public static boolean checkifbooknameExist(Connection connection, String Judul_Buku) throws SQLException{
//        String checkQuery = "SELECT COUNT(*) FROM data_buku WHERE Judul_Buku = ?";
//        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
//        checkStatement.setString(1, Judul_Buku);
//        ResultSet resultSet = checkStatement.executeQuery();
//        resultSet.next();
//        int count = resultSet.getInt(1);
//        return count > 0;
//    }

    public static boolean doesIDBukuExist(Connection connection, int id) throws SQLException {
        return checkIfIdBukuExists(connection, id);
    }
//    public static boolean doesbookexist(Connection connection, String Judul_Buku) throws SQLException{
//        return checkifbooknameExist(connection, Judul_Buku);
//    }

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
