package view;

import common.ConnectDatabase;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.StudentInClass;
import service.StudentService;

public class DialogLopHoc extends javax.swing.JPanel {

    private DefaultTableModel ModelSP;
    private JFrame parentFrame;
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String id = null;

    public DialogLopHoc() {
        initComponents();
        this.parentFrame = parentFrame;
        connection = ConnectDatabase.getMyConnection();
    }

    public DialogLopHoc(ResultSet rs, JFrame parentFrame) {

        initComponents();
        this.parentFrame = parentFrame;
        connection = ConnectDatabase.getMyConnection();
        try {
            className.setText(rs.getString("name"));
            startDate.setText(rs.getString("start_date"));
            endDate.setText(rs.getString("end_date"));
            note.setText(rs.getString("note"));
            id = rs.getString("id");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra " + e);
        }
        TableStu();

    }

    public void TableStu() {
        StudentService studentService = new StudentService();

        ModelSP = new DefaultTableModel();

        TableStu.setModel(ModelSP);
        ModelSP.addColumn("STT");
        ModelSP.addColumn("ID");
        ModelSP.addColumn("Tên học sinh");
        ModelSP.addColumn("Mã học sinh");

        TableStu.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        setDataTableStuInClasses(studentService.getListStuInClass(id));
    }

    private void setDataTableStuInClasses(List<StudentInClass> SPlist) {
        for (StudentInClass stu : SPlist) {
            ModelSP.addRow(new Object[]{
                ModelSP.getRowCount() + 1,
                stu.getId(),
                stu.getUsername(),
                stu.getCode()
            });
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        className = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        startDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        endDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        note = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        addStu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableStu = new javax.swing.JTable();
        homeTeacher = new javax.swing.JComboBox<>();

        className.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel2.setText("Tên lớp học");

        jLabel4.setText("Giáo viên dạy");

        startDate.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel5.setText("Ngày bắt đầu");

        endDate.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel6.setText("Ngày kết thúc");

        note.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel7.setText("Ghi chú");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel1.setText("Thêm mới/Cập nhật lớp học");

        btnSubmit.setText("Lưu");
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
        });

        btnCancel.setText("Hủy");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        addStu.setText("Thêm học sinh");
        addStu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStuMouseClicked(evt);
            }
        });
        addStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStuActionPerformed(evt);
            }
        });

        TableStu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Thao tác", "Tên học sinh", "Mã học sinh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableStu);
        if (TableStu.getColumnModel().getColumnCount() > 0) {
            TableStu.getColumnModel().getColumn(0).setResizable(false);
            TableStu.getColumnModel().getColumn(1).setResizable(false);
            TableStu.getColumnModel().getColumn(2).setResizable(false);
            TableStu.getColumnModel().getColumn(3).setResizable(false);
        }

        homeTeacher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addStu)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancel)
                                .addGap(18, 18, 18)
                                .addComponent(btnSubmit))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(className)
                                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(note, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                    .addComponent(jLabel4)
                                    .addComponent(homeTeacher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(61, 61, 61))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(className, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(note, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(addStu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnCancel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStuActionPerformed

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked

        try {
            StringBuilder sqlBuilder = new StringBuilder();

            if (id == null || id.isEmpty()) {
                // Thêm mới
                sqlBuilder.append("INSERT INTO tbl_classes (name, note) VALUES (?, ?)");
            } else {
                // Cập nhật
                sqlBuilder.append("UPDATE qlhs.tbl_classes SET ");

                if (className.getText() != null && !className.getText().isEmpty()) {
                    sqlBuilder.append("name = ? , ");
                }
                if (note.getText() != null && !note.getText().isEmpty()) {
                    sqlBuilder.append("note = ? ");
                }
                sqlBuilder.append("WHERE (id = ?)");
            }

            pst = connection.prepareStatement(sqlBuilder.toString());

            int parameterIndex = 1;

            if (id == null || id.isEmpty()) {
                // Thêm mới
                pst.setString(parameterIndex++, className.getText());
                pst.setString(parameterIndex++, note.getText());
            } else {
                // Cập nhật
                if (className.getText() != null && !className.getText().isEmpty()) {
                    pst.setString(parameterIndex++, className.getText());
                }
                if (note.getText() != null && !note.getText().isEmpty()) {
                    pst.setString(parameterIndex++, note.getText());
                }
                pst.setString(parameterIndex++, id);
            }

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                if (id == null || id.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Thêm mới lớp học thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật lớp học thành công!");
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

    private void addStuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStuMouseClicked
        JFrame frame = new JFrame("Thêm học sinh vào lớp học");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddStuInClass addStuInClass = new AddStuInClass(id);
        frame.getContentPane().add(addStuInClass);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_addStuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableStu;
    private javax.swing.JButton addStu;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JTextField className;
    private javax.swing.JTextField endDate;
    private javax.swing.JComboBox<String> homeTeacher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField note;
    private javax.swing.JTextField startDate;
    // End of variables declaration//GEN-END:variables
}
