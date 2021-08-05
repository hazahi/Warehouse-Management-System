package com.warehouse.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    private int categoryID;
    private String name;
    private double length;
    private double height;
    private double weight;
    private double price;
    private int numberInStock;
    private String location;
    private int numberShipped;

    public Product() {
    }

    public Product(int categoryID, String name, double length, double weight, double height, double price, int numberInStock, String locationInWarehouse, int numberShipped) {

        this.name = name;
        this.length=length;
        this.weight=weight;
        this.height=height;
        this.price=price;
        this.numberInStock = numberInStock;
        this.numberShipped = numberShipped;
        this.categoryID=categoryID;
        this.location=locationInWarehouse;
    }

    public int getProductID() {
        return this.productID;
    }
    public String getName(){ return this.name; }
    public int getCategoryID(){return this.categoryID;}
    public double getLength() { return this.length; }
    public double getHeight() { return this.height;}
    public double getWeight() { return this.weight;}
    public double getPrice(){return this.price;}
    public int getNumberInStock(){return this.numberInStock;}
    public int getNumberShipped(){return this.numberShipped;}
    public String getLocationInWarehouse(){return this.location;}

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumberInStock(int numberinstock) {
        this.numberInStock = numberinstock;
    }

    public void setNumberShipped(int timesshipped) {
        this.numberShipped = timesshipped;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getProductID() == product.getProductID() &&
                getCategoryID() == product.getCategoryID() &&
                Double.compare(product.getLength(), getLength()) == 0 &&
                Double.compare(product.getHeight(), getHeight()) == 0 &&
                Double.compare(product.getWeight(), getWeight()) == 0 &&
                Double.compare(product.getPrice(), getPrice()) == 0 &&
                getNumberInStock() == product.getNumberInStock() &&
                getNumberShipped() == product.getNumberShipped() &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(location, product.location);
    }

    public int hashCode() {
        return Objects.hash(productID);
    }


    public String toString() {
        return "Product{" +
                "id='" + productID + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", length='" + length + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", number in stock='" + numberInStock + '\'' +
                ", number shipped='" + numberShipped + '\'' +
                ", number shipped='" + location + '\'' +
                '}';
    }
}
