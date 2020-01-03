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
public class nhanvien {
    private int id;
    private String name;
    private String username;
    private String password;
    private int gender;
      private int card;
    private String date;
    private String phone;
    private String email;
    private String address;

    public nhanvien() {
    }

    public nhanvien(int id, String name, String username, String password, int gender, int card, String date, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.card = card;
        this.date = date;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public nhanvien(String name, String username, String password, int gender, int card, String date, String phone, String email, String address) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.card = card;
        this.date = date;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

  
}
