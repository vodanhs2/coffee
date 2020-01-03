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
import model.sanpham;

/**
 *
 * @author Admin
 */
public class sanphamDAO {
      ConnectDB con = new ConnectDB();
    Connection cnn = con.connect(); 
    public int add(sanpham sp){
          try {
              String sql = "INSERT INTO product(name,cat_id,price,status) VALUES(?,?,?,?)";
              PreparedStatement pr = cnn.prepareStatement(sql);
              pr.setString(1, sp.getName());
              pr.setInt(2, sp.getCat_id());
              pr.setFloat(3, sp.getPrice());
              pr.setInt(4, sp.getStatus());
              int row = pr.executeUpdate();
              return row;
          } catch (SQLException ex) {
              Logger.getLogger(sanphamDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("co loi xay ra!");
              return 0;
          }
        
    }
     public List<sanpham> read(){
        try {
            List<sanpham> lssanpham = new ArrayList<>();
            String sql = "SELECT *,FORMAT( create_at, 'dd-MM-yyyy hh:mm:ss tt') AS 'create' from product";
            PreparedStatement pr = cnn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {                
               sanpham sp = new sanpham(rs.getInt("id"), rs.getInt("cat_id"), rs.getString("name"), rs.getFloat("price"), rs.getString("create"), rs.getInt("status"));
                lssanpham.add(sp);
            }
            return lssanpham;
        } catch (SQLException ex) {
            return null;
        }
    }
      public List<sanpham> GetId(int id){
        List<sanpham> lssanpham =  new ArrayList<>();
        String sql = "Select * From product Where id = ?";
        try{
            PreparedStatement pr = cnn.prepareStatement(sql); 
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
               sanpham sp = new sanpham(rs.getInt("id"), rs.getInt("cat_id"), rs.getString("name"), rs.getFloat("price"), rs.getString("create_at"), rs.getInt("status"));
            lssanpham.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return lssanpham; 
    } 
       public int edit(sanpham sp){
          try {
              String sql = "UPDATE product SET name =? ,cat_id=?, price=?,status=?,create_at=GETDATE() WHERE id=?";
              PreparedStatement pr = cnn.prepareStatement(sql);
              pr.setString(1, sp.getName());
              pr.setInt(2, sp.getCat_id());
              pr.setFloat(3, sp.getPrice());
              pr.setInt(4, sp.getStatus());
              pr.setInt(5, sp.getId());
              int row = pr.executeUpdate();
              return row;
          } catch (SQLException ex) {
              Logger.getLogger(sanphamDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("co loi xay ra!");
              return 0;
          }
        
    }
        public boolean delete(ArrayList<Integer> lismanhom){
            boolean check = false;
          try {
              for (int id : lismanhom) {
                  String sql = "DELETE FROM product WHERE id =?";
                  PreparedStatement pr = cnn.prepareStatement(sql);
              pr.setInt(1, id);
              pr.executeUpdate();
              }
              check =true;
             
          } catch (SQLException ex) {
              Logger.getLogger(sanphamDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("co loi xay ra!");
             
          }  
           return check;
    }
         public List<sanpham> Search(String ten){
       List<sanpham> lssanpham =  new ArrayList<sanpham>();
             String sql = "SELECT * FROM product WHERE name LIKE N'%"+ten+"%'";
        try{
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
               sanpham sp = new sanpham(rs.getInt("id"), rs.getInt("cat_id"), rs.getString("name"), rs.getFloat("price"), rs.getString("create_at"), rs.getInt("status"));
                lssanpham.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return lssanpham;
    } 
     
}
