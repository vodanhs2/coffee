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
import model.nhanvien;

/**
 *
 * @author Admin
 */
public class nhanvienDAO {

    ConnectDB con = new ConnectDB();
    Connection cnn = con.connect();    

    public int add(nhanvien nv) {
        try {
            String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pr = cnn.prepareStatement(sql);
            pr.setString(1, nv.getName());
            pr.setString(2, nv.getUsername());
            pr.setString(3, nv.getPassword());
            pr.setInt(4, nv.getGender());
            pr.setInt(5, nv.getCard());
            pr.setString(6, nv.getDate());
            pr.setString(7, nv.getPhone());
            pr.setString(8, nv.getEmail());
            pr.setString(9, nv.getAddress());
            int row = pr.executeUpdate();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(nhanvienDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public List<nhanvien> read() {
        List<nhanvien> lsnhanvien = new ArrayList<>();
        
        try {
            String sql = "select * from employee";
            PreparedStatement pr = cnn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {                
                nhanvien nv = new nhanvien(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("password")
                        , rs.getInt("gender"), rs.getInt("card"), rs.getString("birthday"), rs.getString("phone")
                        , rs.getString("email"), rs.getString("address"));
                lsnhanvien.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(nhanvienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsnhanvien;
        
    }
     public nhanvien getID(int id) {
        nhanvien nv = new nhanvien();
        
        try {
            String sql = "select * from employee WHERE id =?";
            PreparedStatement pr = cnn.prepareStatement(sql);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {                
                 nv = new nhanvien(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("password")
                        , rs.getInt("gender"), rs.getInt("card"), rs.getString("birthday"), rs.getString("phone")
                        , rs.getString("email"), rs.getString("address"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(nhanvienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nv;
        
    }
      public int edit(nhanvien nv) {
        try {
            String sql = "UPDATE employee SET name = ?,username=?,password=?,gender=?,card=?,birthday=?,phone=?,email=?,address=? where id =?";
            PreparedStatement pr = cnn.prepareStatement(sql);
            pr.setString(1, nv.getName());
            pr.setString(2, nv.getUsername());
            pr.setString(3, nv.getPassword());
            pr.setInt(4, nv.getGender());
            pr.setInt(5, nv.getCard());
            pr.setString(6, nv.getDate());
            pr.setString(7, nv.getPhone());
            pr.setString(8, nv.getEmail());
            pr.setString(9, nv.getAddress());
            pr.setInt(10, nv.getId());
            int row = pr.executeUpdate();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(nhanvienDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
      }
      
      public boolean delete(ArrayList<Integer> listnhanvien){
        boolean check = false;
        try{
            String sql;
            for(int ma : listnhanvien){
                sql = "Delete From employee Where id = '"+ma+"'";
                Statement st = cnn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    } 
      public List<nhanvien> Search(String ten){
       List<nhanvien> arrtd =  new ArrayList<>();
        String sql;
            sql = "SELECT * FROM employee WHERE name LIKE N'%"+ten+"%'";
        try{
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
               nhanvien  nv = new nhanvien(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("password")
                        , rs.getInt("gender"), rs.getInt("card"), rs.getString("birthday"), rs.getString("phone")
                        , rs.getString("email"), rs.getString("address"));
                arrtd.add(nv);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    } 
     
}
