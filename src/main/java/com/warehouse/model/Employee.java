package com.warehouse.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String name;
    private String username;
    private String password;

    @ManyToOne(targetEntity = EmployeeRole.class)
    @JoinColumn(name="roleID")
    private EmployeeRole role;

    public Employee(){}

    public Employee(int id,String name,String username, String password){
        this.employeeId=id;
        this.name=name;
        this.password=password;
        this.username=username;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    //public EmployeeRole getEmployeeRole() {
    //    return role;
    //}
    public String getRole(){return role.getName();}
    public String obtainPassword() {
        return password;
    }

    public String obtainUsername() {
        return username;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getEmployeeId() == employee.getEmployeeId() &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(obtainUsername(), employee.obtainUsername()) &&
                Objects.equals(obtainPassword(), employee.obtainPassword()) &&
                Objects.equals(password, employee.password) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getName(), obtainUsername(), password, getRole());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
