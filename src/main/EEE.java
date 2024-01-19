/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EEE {
    private static final String JDBC_URL =  "jdbc:mysql://localhost:3306/qlhs";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Letuan191003+";

    public static void main(String[] args) {
        // Tạo một JFrame
        JFrame frame = new JFrame("Giao Vien ComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Tạo một DefaultComboBoxModel để chứa danh sách giáo viên
        DefaultComboBoxModel<String> giaoVienModel = new DefaultComboBoxModel<>();

        // Lấy danh sách giáo viên từ cơ sở dữ liệu
        ArrayList<String> giaoVienList = retrieveGiaoVienList();

        // Thêm giáo viên vào model
        for (String giaoVien : giaoVienList) {
            giaoVienModel.addElement(giaoVien);
        }

        // Tạo một JComboBox và thiết lập model của nó thành giaoVienModel
        JComboBox<String> giaoVienComboBox = new JComboBox<>(giaoVienModel);

        // Tạo một JPanel để chứa các thành phần
        JPanel panel = new JPanel();
        panel.add(giaoVienComboBox);

        // Thêm JPanel vào JFrame
        frame.add(panel);

        // Hiển thị JFrame
        frame.setVisible(true);
    }

    private static ArrayList<String> retrieveGiaoVienList() {
        ArrayList<String> giaoVienList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Chuẩn bị truy vấn SQL
            String sql = "SELECT username FROM tbl_account";
            preparedStatement = connection.prepareStatement(sql);

            // Thực hiện truy vấn
            resultSet = preparedStatement.executeQuery();

            // Lấy dữ liệu và thêm vào danh sách
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                giaoVienList.add(username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các resource
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return giaoVienList;
    }
}
