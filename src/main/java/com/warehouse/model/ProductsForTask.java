package com.warehouse.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="productstoprepare")
public class ProductsForTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int entryID;

    private int taskID;

    private int productID;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name="productID",referencedColumnName = "productID",insertable = false,updatable = false)
    private Product product;

    private int amount;

    public int obtainEntryID() {
        return entryID;
    }

    public int getTaskID() {
        return taskID;
    }

    public int getAmount() {
        return amount;
    }

    public int getProductID(){
        return this.productID;
    }
    public ProductsForTask(){

    }
    //Used for testing only
    public ProductsForTask(int entryID,int taskID,int productID,int amount,Product product){
        this.entryID=entryID;
        this.taskID=taskID;
        this.product=product;
        this.productID=productID;
        this.amount=amount;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }


}
