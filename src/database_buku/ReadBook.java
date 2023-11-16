package database_buku;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadBook {
    public static List<String[]> readDataBuku(Scanner scanner) {
        List<String[]> datalist = new ArrayList<>();

        try {
            Connection koneksi = BookDataConnector.getConnection();
            Statement st = koneksi.createStatement();
            String query = "SELECT * FROM data_buku";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String[] anggotabuku = new String[5];
                anggotabuku[0] = rs.getString(1); // id
                anggotabuku[1] = rs.getString(2); // Nama
                anggotabuku[2] = rs.getString(3); // Pengarang
                anggotabuku[3] = rs.getString(4); // Penerbit
                anggotabuku[4] = rs.getString(5); // Tahun Terbit

                datalist.add(anggotabuku);
            }
            st.close();
            koneksi.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return datalist;
    }
}
