/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import common.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Classes;
import model.Member;

public class ClassesDAO {

    public List<Classes> getListClasses() {
        List<Classes> SPlist = new ArrayList<Classes>();

        Connection connection = ConnectDatabase.getMyConnection();
        String sql = "SELECT id, name, created_by FROM tbl_classes";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classes classes = new Classes();
                classes.setId(rs.getInt("id"));
                classes.setName(rs.getString("name"));
                classes.setCreatedBy(rs.getString("created_by"));
                SPlist.add(classes);
            }

//            ngắt kết nối database
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        trả về danh sách sản phẩm
        return SPlist;
    }

    public List<Classes> getListClassesByTeacher(int id) {
        List<Classes> SPlist = new ArrayList<Classes>();

        Connection connection = ConnectDatabase.getMyConnection();
        String sql = "SELECT id, name, created_by FROM tbl_classes where account_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classes classes = new Classes();
                classes.setId(rs.getInt("id"));
                classes.setName(rs.getString("name"));
                classes.setCreatedBy(rs.getString("created_by"));
                SPlist.add(classes);
            }

//            ngắt kết nối database
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        trả về danh sách sản phẩm
        return SPlist;
    }

    public void updateClasses(Classes classes) {
    Connection connection = ConnectDatabase.getMyConnection();
    String sql = "UPDATE `qlhs`.`tbl_classes` SET `name` = ?, `note` = ?, `startDate` = ?, `endDate` = ? WHERE (`id` = ?)";

    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, classes.getName());
        ps.setString(2, classes.getNote());
        ps.setString(3, classes.getStartDate());  // Nếu startDate là kiểu DATE, sử dụng ps.setDate(3, Date.valueOf(classes.getStartDate()));
        ps.setString(4, classes.getEndDate());    // Nếu endDate là kiểu DATE, sử dụng ps.setDate(4, Date.valueOf(classes.getEndDate()));
        ps.setInt(5, classes.getId());             // Nếu id là kiểu STRING, sử dụng ps.setString(5, classes.getId());

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không có dòng nào được cập nhật!");
        }

        ps.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void addNewClasses(Classes classes) {
    Connection connection = ConnectDatabase.getMyConnection();
    String sqlGetDetailGiaoVien = "SELECT * FROM `qlhs`.`tbl_account` WHERE id = ? ";
    String sqlAddNewClass = "INSERT INTO `qlhs`.`tbl_classes` (`account_id`, `name`, `note`, `created_by`, `startDate`, `endDate`) VALUES (?, ?, ?, ?, ?, ?)";

    try {
        // Lấy thông tin của tài khoản
        PreparedStatement psGetDetailGiaoVien = connection.prepareStatement(sqlGetDetailGiaoVien);
        psGetDetailGiaoVien.setString(1, classes.getAccountId());
        ResultSet rs = psGetDetailGiaoVien.executeQuery();

        String createdBy = "";  // Mặc định để tránh lỗi biên dịch
        if (rs.next()) {
            createdBy = rs.getString("username");  // Thay "name" bằng tên cột chứa thông tin cần lấy
        }

        // Thêm mới lớp học với thông tin đã lấy
        PreparedStatement psAddNewClass = connection.prepareStatement(sqlAddNewClass);
        psAddNewClass.setString(1, classes.getAccountId());
        psAddNewClass.setString(2, classes.getName());
        psAddNewClass.setString(3, classes.getNote());
        psAddNewClass.setString(4, createdBy);
        psAddNewClass.setString(5, classes.getStartDate());  // Nếu startDate là kiểu DATE, sử dụng ps.setDate(5, Date.valueOf(classes.getStartDate()));
        psAddNewClass.setString(6, classes.getEndDate());    // Nếu endDate là kiểu DATE, sử dụng ps.setDate(6, Date.valueOf(classes.getEndDate()));

        int rowsAffected = psAddNewClass.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Thêm mới thành công!");
        } else {
            System.out.println("Không có dòng nào được thêm mới!");
        }

        rs.close();
        psGetDetailGiaoVien.close();
        psAddNewClass.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public List<Member> getListClassesInRoleSTU(int idAcc) {
        List<Member> SPlist = new ArrayList<Member>();
        String id = String.valueOf(idAcc);
        Connection connection = ConnectDatabase.getMyConnection();
        String sql = "SELECT * FROM `tbl_member` WHERE user_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Member member = new Member();
                member.setCode(rs.getString("code"));
                member.setHomeroom_teacher(rs.getString("homeroom_teacher"));
                member.setEnd_date(rs.getDate("end_date"));
                member.setProject_name(rs.getString("project_name"));
                member.setStart_date(rs.getDate("start_date"));
                SPlist.add(member);
            }

//            ngắt kết nối database
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        trả về danh sách sản phẩm
        return SPlist;
    }

    public List<Classes> deleteClasses(String id) {
        List<Classes> SPlist = new ArrayList<>();

        Connection connection = ConnectDatabase.getMyConnection();
        String deleteSql = "DELETE FROM `qlhs`.`tbl_classes` WHERE (`id` = ?);";
        String selectSql = "SELECT * FROM `qlhs`.`tbl_classes`;";

        try {
            PreparedStatement deletePs = connection.prepareStatement(deleteSql);
            deletePs.setString(1, id);
            int rowsAffected = deletePs.executeUpdate();

            if (rowsAffected > 0) {
                PreparedStatement selectPs = connection.prepareStatement(selectSql);
                ResultSet rs = selectPs.executeQuery();

                while (rs.next()) {
                    Classes sp = new Classes();

                    sp.setId(rs.getInt("id"));
                    SPlist.add(sp);
                }

                // Close result set and statements
                rs.close();
                selectPs.close();
            } else {

            }

            deletePs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return SPlist;
    }
}
