/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sql.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.danhmuc;

/**
 *
 * @author Admin
 */
public class danhmucDAO {
     ConnectDB con = new ConnectDB();
    Connection cnn = con.connect(); 

 
    public int add(danhmuc danhmuc){
        try {
            String sql = "INSERT INTO category VALUES(?,?)";
            PreparedStatement pr = cnn.prepareStatement(sql);
            pr.setString(1, danhmuc.getName());
            pr.setString(2, danhmuc.getColor());
           int row = pr.executeUpdate();
            return  row;
        } catch (SQLException ex) {
            Logger.getLogger(danhmucDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("co loi xay ra!");
            return 0;
        }
        
    }
    public List<danhmuc> read(){
        try {
            List<danhmuc> lsdanhmuc = new ArrayList<>();
            String sql = "SELECT * FROM  category";
            PreparedStatement pr = cnn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {                
                danhmuc nm = new danhmuc(rs.getInt(1),rs.getString(2) , rs.getString(3));
                lsdanhmuc.add(nm);
            }
            return lsdanhmuc;
        } catch (SQLException ex) {
            Logger.getLogger(danhmucDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
      public danhmuc GetId(int id){
        danhmuc nm = new danhmuc();
        String sql = "Select * From category Where id = ?";
        try{
            PreparedStatement pr = cnn.prepareStatement(sql); 
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
               nm = new danhmuc(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return nm; 
    } 
     public int edit(danhmuc danhmuc){
        try {
            String sql = "UPDATE category SET name =? , mausac=? WHERE id=?";
            PreparedStatement pr = cnn.prepareStatement(sql);
            pr.setString(1, danhmuc.getName());
            pr.setString(2, danhmuc.getColor());
            pr.setInt(3, danhmuc.getId());
           int row = pr.executeUpdate();
            return  row;
        } catch (SQLException ex) {
            Logger.getLogger(danhmucDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("co loi xay ra!");
            return 0;
        }
        
    }
public boolean delete(ArrayList<Integer> lismanhom){
        boolean check = false;
        try{
            String sql;
            for(int ma : lismanhom){
                sql = "Delete From category Where id = '"+ma+"'";
                Statement st = cnn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    } 
 public List<danhmuc> Search(String ten){
       List<danhmuc> arrtd =  new ArrayList<danhmuc>();
        String sql;
            sql = "SELECT * FROM category WHERE name LIKE N'%"+ten+"%'";
        try{
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                danhmuc td = new danhmuc(rs.getInt(1), rs.getString(2), rs.getString(3));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    } 
     
}
