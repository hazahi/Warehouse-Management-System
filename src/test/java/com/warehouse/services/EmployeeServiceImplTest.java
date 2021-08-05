package com.warehouse.services;

import com.warehouse.WarehouseApplication;
import com.warehouse.model.Employee;
import com.warehouse.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WarehouseApplication.class)
class EmployeeServiceImplTest {
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration{
        @Bean
        public EmployeeService employeeService(){
            return new EmployeeServiceImpl();
        }
    }
    @Autowired
    EmployeeService employeeService;
    @MockBean
    EmployeeRepository employeeRepository;
    @BeforeEach
    void setUp() {
        Employee employee1=new Employee(1,"Test 1","Test 1","Test 1");
        Employee employee2=new Employee(2,"Test 2","Test 2","Test 2");
        List<Employee>employees=new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        Mockito.when(employeeRepository.findAll()).thenReturn(employees);
    }

    @Test
    void getAllEmployees() {
        Employee employee1=new Employee(1,"Test 1","Test 1","Test 1");
        Employee employee2=new Employee(2,"Test 2","Test 2","Test 2");
        List<Employee>employees=new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        List<Employee>foundEmployees=employeeService.getAllEmployees();
        assertThat(employees).isEqualTo(foundEmployees);
    }


}