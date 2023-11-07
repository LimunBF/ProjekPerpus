package database_buku;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReadBook {
    private static void readBookData(Scanner scanner) {
        try {
            Connection koneksi = BookDataConnector.getConnection();
            Statement st = koneksi.createStatement();
            String query = " select *from data_buku";
            ResultSet rs = st.executeQuery(query);
            System.out.println("--------------------------------------------");
            System.out.println("[DATA BUKU]");
            while (rs.next()) {
                String id = rs.getString(1);
                String judulbuku = rs.getString(2);
                String pengarang = rs.getString(3);
                String pengerbit = rs.getString(4);
                String tahunterbit = rs.getString(5);
                String output = id + " - " + judulbuku + " - " + pengarang + " - " + pengerbit+ " - "+ tahunterbit;
                System.out.println(output);
            }
            st.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
