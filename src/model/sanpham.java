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
public class sanpham {
    private int id;
    private int cat_id;
    private String name;
    private float price;
    private String date;
    private int status;

    public sanpham() {
    }

    public sanpham(int id, int cat_id, String name, float price, String date, int status) {
        this.id = id;
        this.cat_id = cat_id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    public sanpham(int cat_id, String name, float price, int status) {
        this.cat_id = cat_id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public sanpham(int id, int cat_id, String name, float price, int status) {
        this.id = id;
        this.cat_id = cat_id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
