package com.warehouse.services;

import com.warehouse.model.Restock;
import com.warehouse.repository.RestockHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface RestockHistoryService {
    List<Restock> getAllRestocks();
    Restock restockProduct(int employeeID,int productID,int amountRestocked);
}
