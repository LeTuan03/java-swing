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


public class ClassesDAO {
    public List<Classes> getListClasses(){
        List<Classes> SPlist = new ArrayList<Classes>();
        
        Connection connection = ConnectDatabase.getMyConnection();
        String sql = "SELECT id, name, created_by FROM tbl_classes";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Classes classes = new Classes();
                classes.setId(rs.getInt("id"));
                classes.setName(rs.getString("name"));
                classes.setCreatedBy(rs.getString("created_by"));
                SPlist.add(classes);
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
    public void updateClasses(Classes classes){
        
        Connection connection = ConnectDatabase.getMyConnection();
        String sql = "UPDATE `qlhs`.`tbl_classes` SET `name` = ?, `note` = ? WHERE (`id` = ? )";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, classes.getName());
            ps.setString(2, classes.getNote());
            ps.setInt(3, classes.getId());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
            }
            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
