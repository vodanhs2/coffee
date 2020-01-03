/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ConnectDB {
    private final  String SERVER_PATH ="jdbc:sqlserver://localhost:1433;databaseName=coffee";
    private final String USER ="sa";
    private final String PASSWORD ="1234$";
    public Connection connect(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cnn = DriverManager.getConnection(SERVER_PATH,USER,PASSWORD);
            System.out.println("ket noi thanh cong !");
            return cnn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
         return  null;
        }
    
    }
    
}
