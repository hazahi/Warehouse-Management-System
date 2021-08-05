package com.warehouse.controllers;

import com.warehouse.model.Employee;
import com.warehouse.model.Product;
import com.warehouse.repository.EmployeeRepository;
import com.warehouse.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET,path = "/employees/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST,path = "/login")
    @ResponseBody
    public Employee attemptLogin(@RequestBody Map<String,Object> body){

        String username=(String) body.get("username");
        byte[] decodedBytesUsername = Base64.getDecoder().decode(username);
        String decodedUsername= new String(decodedBytesUsername);
        String password = (String) body.get("password");
        byte[] decodedBytesPassword = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytesPassword);
        Employee employee=employeeService.attemptLogin(decodedUsername,decodedPassword);
        return employee;
    }

    @CrossOrigin
    @GetMapping("/employees/{employeeID}")
    public Employee getEmployeeByID(@PathVariable int employeeID){
        return employeeService.getEmployeeWithID(employeeID);
    }
}
