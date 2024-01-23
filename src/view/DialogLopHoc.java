package view;

import common.ConnectDatabase;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import model.Classes;
import model.Member;
import service.ClassesService;
import service.StudentService;

public class DialogLopHoc extends javax.swing.JPanel {

    private DefaultTableModel ModelSP;
    private JFrame parentFrame;
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String id = null;
    Classes classes;
    private JComboBox<String> comboBox;

    public DialogLopHoc() {
        initComponents();
    }

    public DialogLopHoc(ResultSet rs, JFrame parentFrame) {

        initComponents();
        this.parentFrame = parentFrame;
        connection = ConnectDatabase.getMyConnection();
        try {
            className.setText(rs.getString("name"));
            startDate.setText(rs.getString("startDate"));
            endDate.setText(rs.getString("endDate"));
            homeTeacher.setText(rs.getString("account_id"));
            note.setText(rs.getString("note"));
            id = rs.getString("id");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra " + e);
        }
        TableStu();
    }

    public DialogLopHoc(ResultSet rs, JFrame parentFrame, int idAcc) {

        initComponents();
        this.parentFrame = parentFrame;
        connection = ConnectDatabase.getMyConnection();
        try {
            className.setText(rs.getString("name"));
            startDate.setText(rs.getString("startDate"));
            endDate.setText(rs.getString("endDate"));
            homeTeacher.setText(rs.getString("account_id"));
            homeTeacher.enable(false);
            note.setText(rs.getString("note"));
            id = rs.getString("id");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra " + e);
        }
        TableStu();
    }

    public DialogLopHoc(int idAcc) {

        initComponents();
        this.parentFrame = parentFrame;
        connection = ConnectDatabase.getMyConnection();
        try {
            homeTeacher.setText(Integer.toString(idAcc));
            homeTeacher.enable(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra " + e);
        }
        TableStu();
    }

    public void TableStu() {
        StudentService studentService = new StudentService();

        ModelSP = new DefaultTableModel();

        TableStu.setModel(ModelSP);
        ModelSP.addColumn("STT");
        ModelSP.addColumn("Mã học sinh");
        ModelSP.addColumn("Tên học sinh");
        ModelSP.addColumn("Thao tác");

        TableStu.getColumn("Thao tác").setCellRenderer(new ButtonRenderer());
        TableStu.getColumn("Thao tác").setCellEditor(new ButtonEditor());

        TableStu.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        setDataTableStuInClasses(studentService.getListStuInClass(id));
    }

    private void setDataTableStuInClasses(List<Member> SPlist) {
        for (Member stu : SPlist) {
            ModelSP.addRow(new Object[]{
                ModelSP.getRowCount() + 1,
                stu.getUser_id(),
                stu.getUsername(),
                "Xóa"
            });
        }
    }

    private class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }

    private class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

        private JButton button;
        private int selectedRow;

        public ButtonEditor() {
            button = new JButton();
            button.addActionListener(this);
        }

        @Override
        public Object getCellEditorValue() {
            return button.getText();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText(value.toString());
            selectedRow = row;
            return button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa học sinh này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                int row = selectedRow;
                // Xóa dòng tương ứng trong bảng
                ModelSP.removeRow(row);
                // Xóa dữ liệu từ cơ sở dữ liệu
                deleteDataFromDatabase(row);

                TableStu();
            }
            fireEditingStopped();
        }

        private void deleteDataFromDatabase(int row) {
            String studentId = TableStu.getValueAt(row, 1).toString();
            String code = TableStu.getValueAt(row, 3).toString();
            Connection connection = ConnectDatabase.getMyConnection();
            String sql = "DELETE FROM `tbl_member` WHERE user_id = ? AND project_id = ?";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, studentId);
                ps.setString(2, id);
                ps.executeUpdate();

                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        jComboBox1 = new javax.swing.JComboBox<>();
        homeTeacher = new javax.swing.JTextField();

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
                "STT", "Mã học sinh", "Tên học sinh", "Thao tác"
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addGap(0, 954, Short.MAX_VALUE))
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
                                    .addComponent(homeTeacher))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(61, 61, 61))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
        classes = new Classes();
        ClassesService classesService = new ClassesService();
        classes.setName(className.getText());
        classes.setNote(note.getText());
        classes.setAccountId(homeTeacher.getText());
        classes.setStartDate(startDate.getText());
        classes.setEndDate(endDate.getText());

        try {

            if (id == null || id.isEmpty()) {
                // Thêm mới
                classesService.AddNewClassesService(classes);
                JOptionPane.showMessageDialog(null, "Thêm mới lớp học thành công!");
            } else {
                // Cập nhật
                classes.setId(Integer.valueOf(id));
                classesService.UpdateClassesService(classes);
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin lớp học thành công!");
            }
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra " + e);
        }

    }//GEN-LAST:event_btnSubmitMouseClicked

    private void addStuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStuMouseClicked
        if (id == null || id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng tạo mới lớp học trước khi thêm học sinh!");
            addStu.setEnabled(false);
        } else {
            JFrame frame = new JFrame("Thêm học sinh vào lớp học");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            AddStuInClass addStuInClass = new AddStuInClass(id);
            frame.getContentPane().add(addStuInClass);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }//GEN-LAST:event_addStuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableStu;
    private javax.swing.JButton addStu;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JTextField className;
    private javax.swing.JTextField endDate;
    private javax.swing.JTextField homeTeacher;
    private javax.swing.JComboBox<String> jComboBox1;
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
