package com.warehouse.services;

import com.warehouse.model.Employee;
import com.warehouse.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


    public Employee attemptLogin(String username,String password){

        Employee employee=employeeRepository.findEmployeeByUsernameAndPassword(username,password);
        return employee;
    }

    @Override
    public Employee getEmployeeWithID(int employeeID) {
        return employeeRepository.findByEmployeeId(employeeID);
    }
}
