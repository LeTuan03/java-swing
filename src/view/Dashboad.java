package view;

import java.awt.Color;
import model.Account;

public class Dashboad extends javax.swing.JFrame {
    public int idAcc;
    private Account currentAccount;
    Color DefaultColor, ClickedColor;
    public Dashboad() {
        initComponents();
        DefaultColor = new Color(255,255,255);
        ClickedColor = new Color(255,152,51);
        home.setBackground(DefaultColor);
        home1.setBackground(DefaultColor);
        home2.setBackground(DefaultColor);
        home3.setBackground(DefaultColor);
        home4.setBackground(DefaultColor);
    }
    public Dashboad(int data) {
        initComponents();
        idAcc = data;
        DefaultColor = new Color(255,255,255);
        ClickedColor = new Color(255,152,51);
        home.setBackground(DefaultColor);
        home1.setBackground(DefaultColor);
        home2.setBackground(DefaultColor);
        home3.setBackground(DefaultColor);
        home4.setBackground(DefaultColor);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home1 = new javax.swing.JPanel();
        manageStudent = new javax.swing.JLabel();
        home2 = new javax.swing.JPanel();
        manageTeacher = new javax.swing.JLabel();
        home3 = new javax.swing.JPanel();
        manageClasses = new javax.swing.JLabel();
        home4 = new javax.swing.JPanel();
        infoAccount = new javax.swing.JLabel();
        jDesktopPanel = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Trang chủ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(963, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jLabel1.setText("Trang chủ");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        home1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                home1MousePressed(evt);
            }
        });

        manageStudent.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        manageStudent.setText("Quản lý học sinh");
        manageStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageStudentMousePressed(evt);
            }
        });

        javax.swing.GroupLayout home1Layout = new javax.swing.GroupLayout(home1);
        home1.setLayout(home1Layout);
        home1Layout.setHorizontalGroup(
            home1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageStudent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        home1Layout.setVerticalGroup(
            home1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        manageTeacher.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        manageTeacher.setText("Quản lý giáo viên");
        manageTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageTeacherMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageTeacherMousePressed(evt);
            }
        });

        javax.swing.GroupLayout home2Layout = new javax.swing.GroupLayout(home2);
        home2.setLayout(home2Layout);
        home2Layout.setHorizontalGroup(
            home2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        home2Layout.setVerticalGroup(
            home2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        home3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                home3MousePressed(evt);
            }
        });

        manageClasses.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        manageClasses.setText("Quản lý lớp học");
        manageClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageClassesMousePressed(evt);
            }
        });

        javax.swing.GroupLayout home3Layout = new javax.swing.GroupLayout(home3);
        home3.setLayout(home3Layout);
        home3Layout.setHorizontalGroup(
            home3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageClasses)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        home3Layout.setVerticalGroup(
            home3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageClasses, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        home4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                home4MousePressed(evt);
            }
        });

        infoAccount.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        infoAccount.setText("Thông tin cá nhân");

        javax.swing.GroupLayout home4Layout = new javax.swing.GroupLayout(home4);
        home4.setLayout(home4Layout);
        home4Layout.setHorizontalGroup(
            home4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoAccount)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        home4Layout.setVerticalGroup(
            home4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDesktopPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(home4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(home1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(home2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(home3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(home4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jDesktopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        home.setBackground(ClickedColor);
        home1.setBackground(DefaultColor);
        home2.setBackground(DefaultColor);
        home3.setBackground(DefaultColor);
        home4.setBackground(DefaultColor);
        
        title.setText("Trang chủ");
    }//GEN-LAST:event_jLabel1MousePressed

    private void manageStudentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageStudentMousePressed

    }//GEN-LAST:event_manageStudentMousePressed

    private void manageTeacherMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageTeacherMousePressed
        home.setBackground(DefaultColor);
        home1.setBackground(DefaultColor);
        home2.setBackground(ClickedColor);
        home3.setBackground(DefaultColor);
        home4.setBackground(DefaultColor);
        title.setText("Quản lý giáo viên");
    }//GEN-LAST:event_manageTeacherMousePressed

    private void manageClassesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageClassesMousePressed
       
    }//GEN-LAST:event_manageClassesMousePressed

    private void home1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home1MousePressed
        home.setBackground(DefaultColor);
        home1.setBackground(ClickedColor);
        home2.setBackground(DefaultColor);
        home3.setBackground(DefaultColor);
        home4.setBackground(DefaultColor);
        title.setText("Quản lý học sinh");
    }//GEN-LAST:event_home1MousePressed

    private void home3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home3MousePressed
        home.setBackground(DefaultColor);
        home1.setBackground(DefaultColor);
        home2.setBackground(DefaultColor);
        home3.setBackground(ClickedColor);
        home4.setBackground(DefaultColor);
        title.setText("Quản lý lớp học");
    }//GEN-LAST:event_home3MousePressed

    private void home4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home4MousePressed
        home.setBackground(DefaultColor);
        home1.setBackground(DefaultColor);
        home2.setBackground(DefaultColor);
        home3.setBackground(DefaultColor);
        home4.setBackground(ClickedColor);
         title.setText("Thông tin tài khoản");
    }//GEN-LAST:event_home4MousePressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        SideBarHomePage home = new SideBarHomePage();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(home).setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void home1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home1MouseClicked
        SideBarManageStudent manageStudent = new SideBarManageStudent();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(manageStudent).setVisible(true);
    }//GEN-LAST:event_home1MouseClicked

    private void manageTeacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageTeacherMouseClicked
        SideBarManageTeacher manageTeacher = new SideBarManageTeacher();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(manageTeacher).setVisible(true);
    }//GEN-LAST:event_manageTeacherMouseClicked

    private void home3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home3MouseClicked
        SideBarManageClasses manageClaases = new SideBarManageClasses();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(manageClaases).setVisible(true);
    }//GEN-LAST:event_home3MouseClicked

    private void home4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home4MouseClicked
        SideBarAccountInfo accountInfo = new SideBarAccountInfo(idAcc);
        jDesktopPanel.removeAll();
        jDesktopPanel.add(accountInfo).setVisible(true);
    }//GEN-LAST:event_home4MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel home;
    private javax.swing.JPanel home1;
    private javax.swing.JPanel home2;
    private javax.swing.JPanel home3;
    private javax.swing.JPanel home4;
    private javax.swing.JLabel infoAccount;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel manageClasses;
    private javax.swing.JLabel manageStudent;
    private javax.swing.JLabel manageTeacher;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
