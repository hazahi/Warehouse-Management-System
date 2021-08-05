package com.warehouse.services;

import com.warehouse.model.ProductsForTask;
import com.warehouse.repository.ProductsForTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsForTaskServiceImpl implements ProductsForTaskService{
    @Autowired
    ProductsForTaskRepository productsForTaskRepository;
    @Autowired
    ProductService productService;

    @Override
    public ProductsForTask saveProductForTaskWithID(ProductsForTask newTaskProduct,int taskID) {
        ProductsForTask newItem=newTaskProduct;
        newItem.setTaskID(taskID);
        return productsForTaskRepository.save(newItem);
    }

    @Override
    public List<ProductsForTask> getAllProductsForTaskWithID(int taskID) {
        return productsForTaskRepository.getAllByTaskID(taskID);
    }

    @Override
    public ProductsForTask saveProductForTask(ProductsForTask newItem) {
        return productsForTaskRepository.save(newItem);
    }

}
