package dao;


import common.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.StudentInClass;

public class StudentDAO {
    public List<StudentInClass> getListSTU(){
        List<StudentInClass> SPlist = new ArrayList<StudentInClass>();
        
        Connection connection = ConnectDatabase.getMyConnection();
        String sql = "SELECT id, username,phone,email,address,status FROM tbl_account WHERE role = 3";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int test[];
            while(rs.next()){
                StudentInClass sp = new StudentInClass();
                
                sp.setId(rs.getInt("id"));
                sp.setUsername(rs.getString("username"));
                sp.setPhone(rs.getString("phone"));
                sp.setEmail(rs.getString("email"));
                sp.setAddress(rs.getString("address"));
                sp.setStatus(rs.getLong("status"));
                
                SPlist.add(sp);
            }
            
//            ngắt kết nối database
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
//        trả về danh sách sản phẩm
        return SPlist;
    }
    
    public List<StudentInClass> getListStuInClass(String id){
        List<StudentInClass> SPlist = new ArrayList<StudentInClass>();
        
        Connection connection = ConnectDatabase.getMyConnection();
        String sql = "SELECT id, user_id, user_name, code FROM tbl_member WHERE project_id = ?";
        System.out.println(id);
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                StudentInClass sp = new StudentInClass();
                
                sp.setId(rs.getInt("id"));
                sp.setUsername(rs.getString("user_name"));
                sp.setCode(rs.getString("code"));
                SPlist.add(sp);
            }
            
//            ngắt kết nối database
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
//        trả về danh sách sản phẩm
        return SPlist;
    }
}