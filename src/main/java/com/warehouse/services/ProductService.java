package com.warehouse.services;

import com.warehouse.model.Product;
import com.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface ProductService {


    public List<Product> getAllProducts();

    public Product registerNewProduct(String category,String name,double length, double weight,double height, double price,int numberinstock, String location, int timesshipped);

    public Product registerNewProduct(Product product);

    public List<Product> searchForProduct(String searchText);

    public Product findProductByID(int searchId);
    public Product restockProduct(Map<String,Object> updatedProduct, int productID);
    public Product shipProduct(Map<String,Object> updatedProduct,String id);
    public boolean shipProduct(int amount,int productID);


}
