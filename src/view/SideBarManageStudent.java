package view;

import common.ActionButtonTable;
import common.ButtonRenderer;
import common.ConnectDatabase;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.StudentInClass;
import service.StudentService;

public class SideBarManageStudent extends javax.swing.JInternalFrame {

    private DefaultTableModel ModelSP;
    StudentService studentService;
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public SideBarManageStudent() {
        initComponents();
        tbl_account();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        connection = ConnectDatabase.getMyConnection();

    }

    public interface UpdateTableStudent {

        void onUpdatedTable();
    }

    private void tbl_account() {
        studentService = new StudentService();

        ModelSP = new DefaultTableModel() {
            @Override // Không cho người dùng edit table
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ButtonRenderer deleteButton = new ButtonRenderer("Xóa");
        tbl_Student.setModel(ModelSP);
        ModelSP.addColumn("STT");
        ModelSP.addColumn("ID");
        ModelSP.addColumn("Tên học sinh");
        ModelSP.addColumn("Số điện thoại");
        ModelSP.addColumn("Địa chỉ");
        ModelSP.addColumn("Trạng thái");
        ModelSP.addColumn("Thao tác");
        tbl_Student.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tbl_Student.getColumnModel().getColumn(6).setCellRenderer(deleteButton);

        setDataSPtable(studentService.getListSTU());

    }

    private void deleteStudent(String studentID) {
        studentService.deleteAcc(studentID);
        tbl_account();
    }

    private void setDataSPtable(List<StudentInClass> SPlist) {
        for (StudentInClass sp : SPlist) {
            ModelSP.addRow(new Object[]{
                ModelSP.getRowCount() + 1,
                sp.getId(),
                sp.getUsername(),
                sp.getPhone(),
                sp.getEmail(),
                sp.getStatus(),
                "Xóa"
            });
        }
    }

    public void showialogStudent() {
        DialogHocSinh d = new DialogHocSinh();
        d.setVisible(true);
    }

    public void closeDialog() {
        SwingUtilities.getWindowAncestor(this).dispose();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAddNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Student = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        btnAddNew.setText("Thêm mới");
        btnAddNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddNewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddNewMouseEntered(evt);
            }
        });

        tbl_Student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "ưer", "ưer", "ưerwer", "wer", null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Tên học sinh", "Số điện thoại", "Địa chỉ", "Trạng thái", "Xóa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Student.setColumnSelectionAllowed(true);
        tbl_Student.getTableHeader().setReorderingAllowed(false);
        tbl_Student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_StudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Student);
        tbl_Student.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tbl_Student.getColumnModel().getColumnCount() > 0) {
            tbl_Student.getColumnModel().getColumn(0).setResizable(false);
            tbl_Student.getColumnModel().getColumn(1).setResizable(false);
            tbl_Student.getColumnModel().getColumn(2).setResizable(false);
            tbl_Student.getColumnModel().getColumn(3).setResizable(false);
            tbl_Student.getColumnModel().getColumn(4).setResizable(false);
            tbl_Student.getColumnModel().getColumn(5).setResizable(false);
            tbl_Student.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btnAddNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNewMouseEntered


    }//GEN-LAST:event_btnAddNewMouseEntered

    private void tbl_StudentMouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl_Student.getModel();

        if (tbl_Student.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
        } else {
            int selectedColumn = tbl_Student.getSelectedColumn();
            int selectedRow = tbl_Student.getSelectedRow();

            String id = tblModel.getValueAt(selectedRow, 1).toString();
            // Check if the click event occurred on the "Xóa" button (assuming it's the last column)
            if (selectedColumn == tblModel.getColumnCount() - 1) {
                int confirmDialogResult = JOptionPane.showConfirmDialog(
                        null,
                        "Xác nhận xóa học sinh?",
                        "Xóa",
                        JOptionPane.YES_NO_OPTION);

                if (confirmDialogResult == JOptionPane.YES_OPTION) {
                    deleteStudent(id);
                }

            } else {
                if (selectedRow < tblModel.getRowCount() && selectedColumn < tblModel.getColumnCount()) {
                    try {
                        String url = "SELECT * FROM qlhs.tbl_account WHERE (id = ?)";
                        pst = connection.prepareStatement(url);
                        pst.setString(1, id);
                        rs = pst.executeQuery();

                        if (rs.next()) {
                            JFrame frame = new JFrame("Thêm mới/Cập nhật thông tin học sinh");
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.getContentPane().add(new DialogHocSinh(rs, frame));
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
        }
    }

    private void btnAddNewMouseClicked(java.awt.event.MouseEvent evt) {
        JFrame frame = new JFrame("Thêm mới/Cập nhật thông tin học sinh");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DialogHocSinh dialogHocSinh = new DialogHocSinh();
        frame.getContentPane().add(dialogHocSinh);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Student;
    // End of variables declaration//GEN-END:variables
}
