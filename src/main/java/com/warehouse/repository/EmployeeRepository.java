package com.warehouse.repository;

import com.warehouse.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findEmployeeByUsernameAndPassword(String username,String password);
    Employee findByEmployeeId(int employeeID);
}
