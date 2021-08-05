package com.warehouse.services;

import com.warehouse.model.ProductsForTask;

import java.util.List;

public interface ProductsForTaskService {
    ProductsForTask saveProductForTaskWithID(ProductsForTask newTaskProducts,int taskID);
    List<ProductsForTask> getAllProductsForTaskWithID(int taskID);
    ProductsForTask saveProductForTask(ProductsForTask newItem);
}
