package view;

import common.ConnectDatabase;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class DialogGiaoVien extends javax.swing.JPanel {

    private JFrame parentFrame;
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String id = null;

    public DialogGiaoVien() {
        initComponents();
        connection = ConnectDatabase.getMyConnection();
    }

    public DialogGiaoVien(ResultSet rs, JFrame parentFrame) {

        initComponents();
        this.parentFrame = parentFrame;
        connection = ConnectDatabase.getMyConnection();
        try {
            username.setText(rs.getString("username"));
            password.setText(rs.getString("password"));
            phone.setText(rs.getString("phone"));
            email.setText(rs.getString("email"));
            birth.setText(rs.getString("birthDay"));
            id = rs.getString("id");
            if (Integer.parseInt(rs.getString("status")) == 1) {
                statusSelect.setSelectedItem("Hoạt động");
            } else {
                statusSelect.setSelectedItem("Không hoạt động");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra " + e);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        birth = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        statusSelect = new javax.swing.JComboBox<>();

        username.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel2.setText("Tên giáo viên");

        password.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel4.setText("Mật khẩu");

        birth.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel5.setText("Ngày sinh");

        phone.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel6.setText("Số điện thoại");

        email.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel7.setText("Email");

        jLabel8.setText("Trạng thái");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setText("Thêm mới/Cập nhật giáo viên");

        btnSubmit.setText("Lưu");
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubmitMouseEntered(evt);
            }
        });

        btnCancel.setText("Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        statusSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "   ", "Hoạt động", "Không hoạt động" }));
        statusSelect.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusSelectItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(username))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                            .addComponent(email))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(birth, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(66, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(statusSelect, javax.swing.GroupLayout.Alignment.LEADING, 0, 297, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnSubmit)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancel)))
                                .addGap(64, 64, 64))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(birth, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnCancel))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1223, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        try {
            StringBuilder sqlBuilder = new StringBuilder();

            if (id == null || id.isEmpty()) {
                // Thêm mới
                sqlBuilder.append("INSERT INTO tbl_account (");
                sqlBuilder.append("username, password, phone, email, status, birthDay, role");
                sqlBuilder.append(") VALUES (?, ?, ?, ?, ?, ?, 1);");
            } else {
                // Cập nhật
                sqlBuilder.append("UPDATE qlhs.tbl_account SET ");

                if (password.getText() != null && !password.getText().isEmpty()) {
                    sqlBuilder.append("password = ?, ");
                }
                if (username.getText() != null && !username.getText().isEmpty()) {
                    sqlBuilder.append("username = ?, ");
                }
                if (phone.getText() != null && !phone.getText().isEmpty()) {
                    sqlBuilder.append("phone = ?, ");
                }
                if (email.getText() != null && !email.getText().isEmpty()) {
                    sqlBuilder.append("email = ?, ");
                }
                if (statusSelect.getSelectedItem() != null && !statusSelect.getSelectedItem().toString().isEmpty()) {
                    sqlBuilder.append("status = ?, ");
                }
                if (birth.getText() != null && !birth.getText().isEmpty()) {
                    sqlBuilder.append("birthDay = ?, ");
                }

                sqlBuilder.append("role = 1 WHERE (id = ?);");
            }

            pst = connection.prepareStatement(sqlBuilder.toString());

            int parameterIndex = 1;

            if (id == null || id.isEmpty()) {
                // Thêm mới
                pst.setString(parameterIndex++, username.getText());
                pst.setString(parameterIndex++, password.getText());
                pst.setString(parameterIndex++, phone.getText());
                pst.setString(parameterIndex++, email.getText());
                pst.setString(parameterIndex++, birth.getText());
                if(statusSelect.getSelectedItem() != null && !statusSelect.getSelectedItem().toString().isEmpty()) {
                    if(statusSelect.getSelectedItem() == "Hoạt động") {
                        pst.setString(parameterIndex++, "1") ;
                    } else {
                        pst.setString(parameterIndex++, "0");
                    }
                }
            } else {
                // Cập nhật
                if (password.getText() != null && !password.getText().isEmpty()) {
                    pst.setString(parameterIndex++, password.getText());
                }
                if (username.getText() != null && !username.getText().isEmpty()) {
                    pst.setString(parameterIndex++, username.getText());
                }
                if (phone.getText() != null && !phone.getText().isEmpty()) {
                    pst.setString(parameterIndex++, phone.getText());
                }
                if (email.getText() != null && !email.getText().isEmpty()) {
                    pst.setString(parameterIndex++, email.getText());
                }
                if(statusSelect.getSelectedItem() != null && !statusSelect.getSelectedItem().toString().isEmpty()) {
                    if(statusSelect.getSelectedItem() == "Hoạt động") {
                        pst.setString(parameterIndex++, "1") ;
                    } else {
                        pst.setString(parameterIndex++, "0");
                    }
                }
                if (birth.getText() != null && !birth.getText().isEmpty()) {
                    pst.setString(parameterIndex++, birth.getText());
                }
                pst.setString(parameterIndex++, id);
            }

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                if (id == null || id.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Thêm mới giáo viên thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật thông tin giáo viên thành công!");
                }
                Window window = SwingUtilities.getWindowAncestor(this);
                if (window != null) {
                    window.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Thao tác không thành công!");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra " + e);
        }
    }//GEN-LAST:event_btnSubmitMouseClicked

    private void btnSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitMouseEntered

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void statusSelectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusSelectItemStateChanged
        Object selectedValue = statusSelect.getSelectedItem();
        if (selectedValue != null) {
            String selectedStatus = selectedValue.toString();
        }
    }//GEN-LAST:event_statusSelectItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField birth;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField password;
    private javax.swing.JTextField phone;
    private javax.swing.JComboBox<String> statusSelect;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
