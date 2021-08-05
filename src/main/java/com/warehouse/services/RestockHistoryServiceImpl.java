package com.warehouse.services;

import com.warehouse.model.Restock;
import com.warehouse.repository.RestockHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RestockHistoryServiceImpl implements RestockHistoryService{
    @Autowired
    RestockHistoryRepository restockHistoryRepository;

    public List<Restock> getAllRestocks(){
        return restockHistoryRepository.findAll();
    }

    public Restock restockProduct(int employeeID,int productID,int amountRestocked){
        return restockHistoryRepository.save(new Restock(employeeID,productID, LocalDateTime.now(),amountRestocked));
    }
}
