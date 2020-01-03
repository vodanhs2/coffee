/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.admin;
import model.nhanvien;

/**
 *
 * @author Admin
 */
public class run {
  public static frmain QlCafe;
  public static frmLogIn login;
   public static admin tk;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      LOG();
//     QLCF();
    }
    public static void QLCF(){
        QlCafe = new frmain();
        QlCafe.setVisible(true);       
    }
    public static void LOG(){
    login = new frmLogIn();
    login.setVisible(true);
    }
    
}
