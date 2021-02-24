package com.company.entities;

import java.sql.Date;
import java.time.LocalDate;

public class Medicine {
    private int id;
    private String name;
    private int price;
    private Date expiration;
    private String manufacturer;

    public Medicine(){

    }
    public Medicine(String name, int price, String expiration, String manufacturer){
    setName(name);
    setPrice(price);
    setExpiration(expiration);
    setManufacturer(manufacturer);
    }
    public Medicine(int id, String name, int price, String expiration, String manufacturer){
        setId(id);
        setName(name);
        setPrice(price);
        setExpiration(expiration);
        setManufacturer(manufacturer);
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = Date.valueOf(expiration);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expiration=" + expiration +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
