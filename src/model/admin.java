/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class admin {
    private int id;
    private String username;
    private String password;

  private int lever;

    public admin() {
    }

    public admin(int id, String username, String password, int lever) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lever = lever;
    }

    public admin(String username, String password, int lever) {
        this.username = username;
        this.password = password;
        this.lever = lever;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
    }
}
