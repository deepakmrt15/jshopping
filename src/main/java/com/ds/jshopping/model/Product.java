package com.ds.jshopping.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="category")
    private String category;

    public Product() {
    }

    public Product(String name, String category, String imagepath, String price) {
        this.name = name;
        this.category = category;
        this.imagepath = imagepath;
        this.price = price;
    }

    @Column(name="imagepath")
    private String imagepath;
    @Column(name="price")
    private String price;

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
