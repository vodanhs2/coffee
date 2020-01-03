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
import model.admin;
import model.nhanvien;

/**
 *
 * @author Admin
 */
public class loginDAO {
   ConnectDB con = new ConnectDB();
    Connection cnn = con.connect(); 
    public boolean CheckLoginAdmin(admin ad){
    boolean check = false;
    String sql = "SELECT * FROM admin WHERE username=? and password =?";
        PreparedStatement pr;
       try {
           pr = cnn.prepareStatement(sql);
            pr.setString(1, ad.getUsername());
        pr.setString(2, ad.getPassword());
           ResultSet rs = pr.executeQuery();
           while (rs.next()) {               
               check =true;
           }
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
       }
       return check;
      
    }
      public admin GetAdmin(String name, String pass){
        admin ad = new admin();
         String sql = "SELECT * FROM admin WHERE username=? and password =?";
        try{
           PreparedStatement pr = cnn.prepareStatement(sql);
            pr.setString(1,name);
        pr.setString(2, pass);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
             ad = new admin(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return ad;
    }
      
     public boolean CheckLoginNhanvien(nhanvien nv){
    boolean check = false;
    String sql = "SELECT name,username,password FROM employee WHERE username=? and password =?";
        PreparedStatement pr;
       try {
           pr = cnn.prepareStatement(sql);
            pr.setString(1, nv.getUsername());
        pr.setString(2, nv.getPassword());
           ResultSet rs = pr.executeQuery();
           while (rs.next()) {               
               check =true;
           }
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
       }
       return check;
      
    }
      public admin GetNhanvien(String name, String pass){
        admin nv = new admin();
         String sql = "SELECT id,name,username,password FROM employee WHERE username=? and password =?";
        try{
           PreparedStatement pr = cnn.prepareStatement(sql);
            pr.setString(1,name);
        pr.setString(2, pass);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
            nv.setId(rs.getInt("id"));
            
            nv.setUsername(rs.getString("username"));
            nv.setPassword(rs.getString("password"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return nv;
    }
      
       public int LVTK(admin tk) {
        int lvtk =0;
        String sql;
            sql = "Select lever From admin Where username = '"+tk.getUsername()+"' AND password='"+tk.getPassword()+"'";
        try{
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                lvtk = rs.getInt(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return lvtk; 
    } 
}
