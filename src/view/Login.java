package view;
import java.sql.Connection;
import common.ConnectDatabase;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import model.Account;

public class Login extends javax.swing.JPanel {
    private ThongTinHocSinh thongtinhocsinh;
    private Dashboad dashboad;
    private JFrame newFrame; // Thêm biến JFrame mới

    public Login(ThongTinHocSinh thongtinhocsinh) {
        this.thongtinhocsinh = thongtinhocsinh;
        initComponents();
    }
    public Login() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1245, 675));

        login.setText("Đăng nhập");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên tài khoản");

        jLabel2.setText("Mật khẩu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(username)
                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(781, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        
        String username = this.username.getText();
        String password = this.password.getText();
        
        try {
            Connection connection = ConnectDatabase.getMyConnection();
            String query = "SELECT id, role, username, password FROM tbl_account WHERE username = ? AND password = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");
                String dbRole = resultSet.getString("role");
                int dbId = resultSet.getInt("id");
                Account currentAccount;
                currentAccount = new Account();
                currentAccount.setUsername(dbUsername);
                currentAccount.setPassword(dbPassword);
                currentAccount.setRole(dbRole);
                currentAccount.setId(dbId);
                
                dashboad = new Dashboad(currentAccount);
                newFrame = new JFrame("Danh sách học sinh");
                newFrame.getContentPane().add(dashboad);

                // Thiết lập thuộc tính cho JFrame mới
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newFrame.pack();
                newFrame.setLocationRelativeTo(null);
                newFrame.setVisible(true);

                // Đóng form login
                JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                loginFrame.dispose();
            } else {
                System.out.println("Error.");
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }//GEN-LAST:event_loginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton login;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
