package com.warehouse.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="restockhistory")
public class Restock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int entryID;

    @Column(name = "employeeID")
    private int employeeID;

    @Column(name="productID")
    private int productID;

    @Column(name="restockDate")
    private LocalDateTime restockDate;

    @Column(name="amountRestocked")
    private int amountRestocked;

    public Restock(){}
    public Restock(int employeeID,int productID,LocalDateTime restockDate, int amountRestocked){
        this.employeeID=employeeID;
        this.productID=productID;
        this.restockDate=restockDate;
        this.amountRestocked=amountRestocked;
    }

    public int getEntryID() {
        return entryID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getProductID() {
        return productID;
    }

    public LocalDateTime getRestockDate() {
        return restockDate;
    }

    public int getAmountRestocked() {
        return amountRestocked;
    }

    public void setEntryID(int entryID) {
        this.entryID = entryID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setAmountRestocked(int amountRestocked) {
        this.amountRestocked = amountRestocked;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setRestockDate(LocalDateTime restockDate) {
        this.restockDate = restockDate;
    }

    @Override
    public String toString() {
        return "Restock{" +
                "entryID=" + entryID +
                ", employeeID=" + employeeID +
                ", productID=" + productID +
                ", restockDate=" + restockDate +
                ", amountRestocked=" + amountRestocked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restock restock = (Restock) o;
        return getEntryID() == restock.getEntryID() &&
                getEmployeeID() == restock.getEmployeeID() &&
                getProductID() == restock.getProductID() &&
                getAmountRestocked() == restock.getAmountRestocked() &&
                Objects.equals(getRestockDate(), restock.getRestockDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEntryID(), getEmployeeID(), getProductID(), getRestockDate(), getAmountRestocked());
    }
}
