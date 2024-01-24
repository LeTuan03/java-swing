package view;

import common.ConnectDatabase;
import java.awt.Container;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DialogHocSinh extends javax.swing.JPanel {

    private JFrame parentFrame;
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String id = null;

    public DialogHocSinh() {
        initComponents();
        connection = ConnectDatabase.getMyConnection();

    }

    public void display() {
        this.setVisible(true);
    }

    public DialogHocSinh(ResultSet rs, JFrame parentFrame) {

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

        jLabel2.setText("Tên học sinh");

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
        jLabel1.setText("Thêm mới/Cập nhật học sinh");

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

        statusSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "       ", "Hoạt động", "Không hoạt động" }));
        statusSelect.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusSelectItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                            .addComponent(email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSubmit)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel)
                                .addGap(64, 64, 64))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(birth, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(66, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(birth, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusSelect))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnCancel))
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        try {
            StringBuilder sqlBuilder = new StringBuilder();

            if (id == null || id.isEmpty()) {
                // Thêm mới
                sqlBuilder.append("INSERT INTO tbl_account (");
                sqlBuilder.append("username, password, phone, email, status, birthDay, role");
                sqlBuilder.append(") VALUES (?, ?, ?, ?, ?, ?, 3);");
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

                sqlBuilder.append("role = 3 WHERE (id = ?);");
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
                    JOptionPane.showMessageDialog(null, "Thêm mới học sinh thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật học sinh thành công!");
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

    private void statusSelectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusSelectItemStateChanged
        Object selectedValue = statusSelect.getSelectedItem();
        if (selectedValue != null) {
            String selectedStatus = selectedValue.toString();
        }
    }//GEN-LAST:event_statusSelectItemStateChanged

    private void btnSubmitMouseEntered(java.awt.event.MouseEvent evt) {

    }


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
    private javax.swing.JTextField password;
    private javax.swing.JTextField phone;
    private javax.swing.JComboBox<String> statusSelect;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
