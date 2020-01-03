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
import model.ban;

/**
 *
 * @author Admin
 */
public class banDAO {

    ConnectDB con = new ConnectDB();
    Connection cnn = con.connect();

    public int add(ban b) {
        try {
            String sql = "INSERT INTO coffee_table VALUES (?,?)";
            PreparedStatement pr = cnn.prepareStatement(sql);
            pr.setString(1, b.getName());
            pr.setInt(2, b.getStatus());
            int row = pr.executeUpdate();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(banDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public List<ban> read() {
        try {
            List<ban> lsban = new ArrayList<>();
            String sql = "select * from coffee_table";
            PreparedStatement pr = cnn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                ban b = new ban(rs.getInt(1), rs.getString(2), rs.getInt(3));
                lsban.add(b);
            }
            return lsban;
        } catch (SQLException ex) {
            Logger.getLogger(banDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ban getIdBan(int id) {
        try {
            ban b = new ban();
            String sql = "select * from coffee_table where id = ?";
            PreparedStatement pr = cnn.prepareStatement(sql);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                b = new ban(rs.getInt(1), rs.getString(2), rs.getInt(3));

            }
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(banDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int edit(ban b) {
        try {
            String sql = "UPDATE coffee_table SET name =?,status=? where id =? ";
            PreparedStatement pr = cnn.prepareStatement(sql);
            pr.setString(1, b.getName());
            pr.setInt(2, b.getStatus());
            pr.setInt(3, b.getId());
            int row = pr.executeUpdate();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(banDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public boolean delete(ArrayList<Integer> lsban) {
        boolean check = false;
        try {
            for (int ma : lsban) {
                String sql = "Delete From coffee_table Where id = '"+ma+"'";
                Statement st = cnn.createStatement();
                st.executeUpdate(sql);
            }
            check = true;
        } catch (SQLException ex) {
            Logger.getLogger(banDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
    public List<ban> Search(String ten){
       List<ban> lsban =  new ArrayList<>();
        String sql;
            sql = "SELECT * FROM coffee_table WHERE name LIKE N'%"+ten+"%'";
        try{
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                ban td = new ban(rs.getInt(1), rs.getString(2), rs.getInt(3));
                lsban.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return lsban;
    } 
}
