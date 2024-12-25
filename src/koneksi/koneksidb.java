package koneksi;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksidb {

    private static Connection connection;
    static Object get;

    public static Connection Go() {
        try {
            String url = "jdbc:mysql://localhost:3306/toko_kopi"; // Ganti sesuai nama database Anda
            String user = "root"; // Ganti sesuai username MySQL Anda
            String password = ""; // Ganti sesuai password MySQL Anda

            connection = DriverManager.getConnection(url, user, password); // Gunakan variabel instance
            connection.setAutoCommit(false);
            System.out.println("Koneksi berhasil dijalankan!");

        } catch (SQLException e) {
            System.err.println("Koneksi Gagal: " + e.getMessage());
            Logger.getLogger(koneksidb.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = Go(); // Panggil method Go untuk tes koneksi
        if (connection != null) {
            System.out.println("Tes koneksi berhasil dijalankan!");
        }
    }

    public static Connection getConnection() {
    if (connection == null) {
            connection = Go(); // Panggil Go jika belum ada koneksi
        }
        return connection;
    }
    

}


