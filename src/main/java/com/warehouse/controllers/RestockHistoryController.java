package com.warehouse.controllers;

import com.warehouse.model.Product;
import com.warehouse.model.Restock;
import com.warehouse.services.RestockHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restockhistory")
public class RestockHistoryController {

    @Autowired
    RestockHistoryService restockHistoryService;

    @CrossOrigin()
    @GetMapping("/all")
    public List<Restock> getAllRestocks(){
        return restockHistoryService.getAllRestocks();
    }
//    @CrossOrigin()
//    @PostMapping("/test")
//    public Restock testRestockRequest(@RequestBody Restock restock){
//
//        return restockHistoryService.restockProduct(restock.getEmployeeID(), restock.getProductID(), restock.getAmountRestocked());
//    }

}
