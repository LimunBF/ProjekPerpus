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


    public static boolean doesIDBukuExist(Connection connection, int id) throws SQLException {
        return checkIfIdBukuExists(connection, id);
    }
//    public static boolean doesUserexist(Connection connection, String username) throws SQLException{
//        return checkifUsernameExist(connection, Username);
//    }

    public static List<String> getNamesFromDatabase() throws ClassNotFoundException, SQLException {
        List<String> names = new ArrayList<>();
        Connection connection = getConnection();

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
    
    public static List<String> getsTitleFromDatabase() throws ClassNotFoundException, SQLException {
        List<String> title = new ArrayList<>();
        Connection connection = getConnection();

        String selectQuery = "SELECT DISTINCT Judul_Buku FROM data_buku";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String booktitle = resultSet.getString("Judul_Buku");
                title.add(booktitle);
            }
        }
        connection.close();
        return title;
    }
    
    public static List<String> getNIMFromDatabase(String name) throws ClassNotFoundException, SQLException {
        List<String> nim = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT DISTINCT NIM FROM anggota_perpus WHERE Nama = ?")) {

            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String nims = resultSet.getString("NIM");
                    nim.add(nims);
                }
            }
        } catch (SQLException e) {
            // Log the exception or handle it according to your application's requirements
            throw e; // Rethrow the exception or return a meaningful result
        }

        return nim;
    }

    public static List<String> getFakultasFromDatabase(String name) throws ClassNotFoundException, SQLException {
        List<String> fakultas = new ArrayList<>();
        Connection connection = getConnection();

        String selectQuery = "SELECT DISTINCT Fakultas FROM anggota_perpus WHERE Nama = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String fakulta = resultSet.getString("Fakultas");
                    fakultas.add(fakulta);
                }
            }
        }
        connection.close();
        return fakultas;
    }

    public static List<String> getProdiFromDatabase(String name) throws ClassNotFoundException, SQLException {
        List<String> prodis = new ArrayList<>();
        Connection connection = getConnection();

        String selectQuery = "SELECT DISTINCT Prodi FROM anggota_perpus WHERE Nama = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String prodi = resultSet.getString("Prodi");
                    prodis.add(prodi);
                }
            }
        }
        connection.close();
        return prodis;
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
    
    public static int getRecordId(String judulBuku, String peminjam, String nimPeminjam) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT id FROM anggota_perpus WHERE buku_yg_dipinjam = ? AND Nama = ? AND NIM = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, judulBuku);
                preparedStatement.setString(2, peminjam);
                preparedStatement.setString(3, nimPeminjam);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("id");
                    }
                }
            }
        } catch (SQLException e) {
            // Log the exception or handle it according to your application's requirements
            throw e; // Rethrow the exception or return a meaningful result
        }
        return -1; // Return a default value or handle the case where no record is found
    }
}
