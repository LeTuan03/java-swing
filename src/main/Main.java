package main;

import javax.swing.JFrame;

import view.Login;

public class Main {
    public static void main(String [] args) {
        
        JFrame frame = new JFrame("Ứng dụng quản lý học sinh");

        // Thêm Login panel vào JFrame
        Login loginPanel = new Login();
        frame.getContentPane().add(loginPanel);

        // Thiết lập thuộc tính cho JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    };
}
