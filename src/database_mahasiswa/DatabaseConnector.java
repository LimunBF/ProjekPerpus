package database_mahasiswa;

import java.sql.*;

public class DatabaseConnector {
    private static String url = "jdbc:mysql://localhost:3306/database_perpus";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
    private static boolean checkIfIdExists(Connection connection, int id) throws SQLException {
        String checkQuery = "SELECT COUNT(*) FROM mahasiswa WHERE ID = ?";
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

    public static boolean doesIdExist(Connection connection, int id) throws SQLException {
        return checkIfIdExists(connection, id);
    }

    public static boolean doesIDBukuExist(Connection koneksi, int id) {
        return false;
    }

//    public static boolean doesUserexist(Connection connection, String username) throws SQLException{
//        return checkifUsernameExist(connection, Username);
//    }
}
