package database_admin;

import java.sql.*;

public class AdminConnector {
    private static String url = "jdbc:mysql://localhost:3306/projek_perpus";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    private static boolean checkifadminexist(Connection connection, String username) throws SQLException {
        String checkQuery = "SELECT COUNT(*) FROM data_admin WHERE username = ?";
        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
        checkStatement.setString(1, username);
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        return count > 0;
    }

    public static boolean doesadminexist(Connection connection, String username) throws SQLException {
        return checkifadminexist(connection, username);
    }


}
