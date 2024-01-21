/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import common.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.Classes;
import model.StudentInClass;
import service.ClassesService;

public class SideBarManageClasses extends javax.swing.JInternalFrame {

    public int idAcc;
    private DefaultTableModel ModelClasses;
    ClassesService classesService;
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public SideBarManageClasses() {
        initComponents();
        tbl_classes();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        connection = ConnectDatabase.getMyConnection();
    }

    public SideBarManageClasses(int id) {
        initComponents();
        idAcc = id;
        System.out.println(id);
        tbl_classes();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        connection = ConnectDatabase.getMyConnection();
    }

    public void tbl_classes() {
        classesService = new ClassesService();
        ModelClasses = new DefaultTableModel();

        tbl_Classes.setModel(ModelClasses);
        ModelClasses.addColumn("STT");
        ModelClasses.addColumn("ID");
        ModelClasses.addColumn("Tên lớp học");
        ModelClasses.addColumn("Giáo viên dạy");
        if (idAcc > 0) {
            setDataTableClasses(classesService.getListClassesByTeacher(idAcc));
        } else {
            setDataTableClasses(classesService.getListClasses());
        }
    }

    private void setDataTableClasses(List<Classes> SPlist) {
        for (Classes cl : SPlist) {
            ModelClasses.addRow(new Object[]{
                ModelClasses.getRowCount() + 1,
                cl.getId(),
                cl.getName(),
                cl.getCreatedBy()
            });
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAddNew = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Classes = new javax.swing.JTable();

        jPanel2.setPreferredSize(new java.awt.Dimension(940, 61));

        btnAddNew.setText("Thêm mới");
        btnAddNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddNewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnAddNew)
                    .addContainerGap(850, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(13, Short.MAX_VALUE)
                    .addComponent(btnAddNew)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        tbl_Classes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"c", "d", "e", "f"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tên lớp học", "Giáo viên dạy", "Sĩ số lớp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Classes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ClassesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_ClassesMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Classes);
        if (tbl_Classes.getColumnModel().getColumnCount() > 0) {
            tbl_Classes.getColumnModel().getColumn(0).setResizable(false);
            tbl_Classes.getColumnModel().getColumn(1).setResizable(false);
            tbl_Classes.getColumnModel().getColumn(2).setResizable(false);
            tbl_Classes.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_ClassesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ClassesMouseEntered


    }//GEN-LAST:event_tbl_ClassesMouseEntered

    private void tbl_ClassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ClassesMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel) tbl_Classes.getModel();
        if (tbl_Classes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
        } else {
            int selectedRow = tbl_Classes.getSelectedRow();

            if (selectedRow < tblModel.getRowCount() && 1 < tblModel.getColumnCount()) {
                String id = tblModel.getValueAt(selectedRow, 1).toString();
                try {
                    String url = "SELECT * FROM qlhs.tbl_classes WHERE (id = ?)";
                    pst = connection.prepareStatement(url);
                    pst.setString(1, id);
                    rs = pst.executeQuery();

                    if (rs.next()) {
                        JFrame frame = new JFrame("Thêm mới/Cập nhật thông tin lớp học");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        if (idAcc > 0) {
                            frame.getContentPane().add(new DialogLopHoc(rs, frame, idAcc));
                        } else {
                            frame.getContentPane().add(new DialogLopHoc(rs, frame));
                        }
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
    }//GEN-LAST:event_tbl_ClassesMouseClicked

    private void btnAddNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewMouseClicked
        JFrame frame = new JFrame("Thêm mới/Cập nhật thông tin lớp học");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DialogLopHoc(idAcc));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddNewMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Classes;
    // End of variables declaration//GEN-END:variables
}
