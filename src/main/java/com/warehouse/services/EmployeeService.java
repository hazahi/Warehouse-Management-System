package com.warehouse.services;

import com.warehouse.model.Employee;
import com.warehouse.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee attemptLogin(String username,String password);
    public Employee getEmployeeWithID(int employeeID);
}
