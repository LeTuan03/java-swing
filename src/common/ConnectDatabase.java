package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
    private static String url = "jdbc:mysql://localhost:3306/qlhs";
    private static String user = "root";
    private static String pass = "Letuan191003+";

    public static Connection getMyConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = getMyConnection();

        if (connection != null) {
            System.out.println("Kết nối thành công!");
        } else {
            System.out.println("Kết nối thất bại!");
        }
    }
}
