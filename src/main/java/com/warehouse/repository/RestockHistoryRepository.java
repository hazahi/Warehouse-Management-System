package com.warehouse.repository;

import com.warehouse.model.Restock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RestockHistoryRepository extends JpaRepository<Restock,Integer> {
    List<Restock>findAllByEmployeeID(int employeeID);
    List<Restock>findAllByProductID(int productID);
    List<Restock>findAllByRestockDateContaining(LocalDate restockDate);
}
