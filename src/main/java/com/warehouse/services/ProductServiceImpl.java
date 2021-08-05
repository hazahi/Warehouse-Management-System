package com.warehouse.services;

import com.warehouse.model.Product;
import com.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RestockHistoryService restockHistoryService;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product registerNewProduct(String category, String name, double length, double weight, double height, double price, int numberinstock, String location, int timesshipped){
        Product newProduct=new Product(1,name,length,weight, height, price, numberinstock, location, timesshipped);
        return productRepository.save(newProduct);
    }
    public Product registerNewProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> searchForProduct(String searchText){
        List<Product>products=productRepository.findByNameContaining(searchText);
        return products;
    }
    public Product findProductByID(int searchId){
        Product product=productRepository.findByProductID(searchId);
        return product;
    }
    public Product restockProduct(Map<String,Object> updatedProduct, int productID){
        int employeeID =(int)updatedProduct.get("employeeID");
        int amount=(int)updatedProduct.get("amountRestocked");
        return productRepository.findById(productID)
                .map(product -> {
                    product.setNumberInStock(product.getNumberInStock()+amount);
                    restockHistoryService.restockProduct(employeeID,product.getProductID(),amount);
                    return productRepository.save(product);

                }).orElseGet(()->{
                    return null;
                });

    }
    public Product shipProduct(Map<String,Object> updatedProduct,String id){
        int productID = Integer.parseInt(id);
        int amount=(int)updatedProduct.get("numberShipped");
        return productRepository.findById(productID)
                .map(product -> {
                    product.setNumberInStock(product.getNumberInStock()-amount);
                    product.setNumberShipped(product.getNumberShipped()+amount);
                    return productRepository.save(product);
                }).orElseGet(()->{
                    return null;
                });

    }

    @Override
    public boolean shipProduct(int amount, int productID) {
        return productRepository.findById(productID)
                .map(product -> {
                    product.setNumberInStock(product.getNumberInStock()-amount);
                    product.setNumberShipped(product.getNumberShipped()+amount);
                     productRepository.save(product);
                     return true;
                }).orElseGet(()->{
                    return false;
                });
    }
}
