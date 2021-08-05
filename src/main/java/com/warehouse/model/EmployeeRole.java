package com.warehouse.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="role")
public class EmployeeRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleID;

    private String name;

    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
    private List<Employee> employee;

    public EmployeeRole(){}
    public EmployeeRole(String name){
        this.name=name;
    }

    public int getRoleID() {
        return roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeRole that = (EmployeeRole) o;
        return getRoleID() == that.getRoleID() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleID(), getName());
    }

    @Override
    public String toString() {
        return "EmployeeRole{" +
                "roleID=" + roleID +
                ", name='" + name + '\'' +
                '}';
    }
}
