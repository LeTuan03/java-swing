package view;

import common.ButtonRenderer;
import common.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.StudentInClass;
import service.ClassesService;
import service.StudentService;

public class SideBarManageTeacher extends javax.swing.JInternalFrame {

    private DefaultTableModel ModelSP;
    StudentService studentService;
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public SideBarManageTeacher() {
        initComponents();
        tbl_account();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        connection = ConnectDatabase.getMyConnection();
    }

    public SideBarManageTeacher(int idAcc) {
        initComponents();
    }

    private void tbl_account() {
        studentService = new StudentService();
        ModelSP = new DefaultTableModel();

        ButtonRenderer deleteButton = new ButtonRenderer("Xóa");
        tbl_Teacher.setModel(ModelSP);
        ModelSP.addColumn("STT");
        ModelSP.addColumn("ID");
        ModelSP.addColumn("Tên giáo viên");
        ModelSP.addColumn("Số điện thoại");

        tbl_Teacher.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tbl_Teacher.getColumnModel().getColumn(3).setCellRenderer(deleteButton);
        setDataSPtable(studentService.getListTeacher());
    }

    private void setDataSPtable(List<StudentInClass> SPlist) {
        for (StudentInClass sp : SPlist) {
            ModelSP.addRow(new Object[]{
                ModelSP.getRowCount() + 1,
                sp.getId(),
                sp.getUsername(),
                sp.getPhone(),
                "Xóa"
            });
        }
    }

    private void deleteTeacher(String teacherID) {
        studentService.deleteAcc(teacherID);
        tbl_account();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnAddNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Teacher = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnAddNew.setText("Thêm mới");
        btnAddNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddNewMouseClicked(evt);
            }
        });

        tbl_Teacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null},
                {"12", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Tên giáo viên", "Số điện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Teacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TeacherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Teacher);
        if (tbl_Teacher.getColumnModel().getColumnCount() > 0) {
            tbl_Teacher.getColumnModel().getColumn(0).setResizable(false);
            tbl_Teacher.getColumnModel().getColumn(1).setResizable(false);
            tbl_Teacher.getColumnModel().getColumn(2).setResizable(false);
            tbl_Teacher.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAddNew)
                        .addContainerGap(855, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnAddNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 945, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_TeacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TeacherMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel) tbl_Teacher.getModel();

        if (tbl_Teacher.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
        } else {
            int selectedRow = tbl_Teacher.getSelectedRow();
            int selectedColumn = tbl_Teacher.getSelectedColumn();
            String id = tblModel.getValueAt(selectedRow, 1).toString();
            
            if (selectedColumn == tblModel.getColumnCount() - 1) {
                int confirmDialogResult = JOptionPane.showConfirmDialog(
                        null,
                        "Xác nhận xóa giáo viên?",
                        "Xóa",
                        JOptionPane.YES_NO_OPTION);

                if (confirmDialogResult == JOptionPane.YES_OPTION) {
                    deleteTeacher(id);
                }

            } else if (selectedRow < tblModel.getRowCount() && 1 < tblModel.getColumnCount()) {
                try {
                    String url = "SELECT * FROM qlhs.tbl_account WHERE (id = ?)";
                    pst = connection.prepareStatement(url);
                    pst.setString(1, id);
                    rs = pst.executeQuery();

                    if (rs.next()) {
                        JFrame frame = new JFrame("Thêm mới/Cập nhật thông tin giáo viên");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.getContentPane().add(new DialogGiaoVien(rs, frame));
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin tài khoản!");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra " + e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid row or column index.");
            }
        }
    }//GEN-LAST:event_tbl_TeacherMouseClicked

    private void btnAddNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewMouseClicked
        JFrame frame = new JFrame("Thêm mới/Cập nhật thông tin giáo viên");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DialogGiaoVien dialogGiaoVien = new DialogGiaoVien();
        frame.getContentPane().add(dialogGiaoVien);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddNewMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Teacher;
    // End of variables declaration//GEN-END:variables
}
