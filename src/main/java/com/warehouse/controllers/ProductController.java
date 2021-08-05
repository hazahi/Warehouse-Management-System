package com.warehouse.controllers;

import com.warehouse.model.Product;
import com.warehouse.repository.*;

import com.warehouse.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;
   
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,path = "/all")
    public List<Product> getAllProducts(){
    return productService.getAllProducts();
    }


    @CrossOrigin
    @PostMapping("/newProduct")
    public Product create(@RequestBody Map<String,Object> body){
        String categoryID=(String) body.get("category");
        String name = (String) body.get("name");
        double length ;
        if(body.get("length") instanceof Integer){
            length = (int) body.get("length");
        }
        else {
            length = (double) body.get("length");
        }
        double weight;
        if(body.get("weight")instanceof Integer){
            weight=(int)body.get("weight");
        }
        else {
            weight=(double)body.get("weight");
        }
        double height;
        if(body.get("height")instanceof Integer){
            height=(int)body.get("height");
        }
        else {
            height= (double) body.get("height");
        }
        double price=(int)body.get("price");
        int numberinstock=(int)body.get("numberInStock");
        String location=(String) body.get("location");
        int timesshipped=0;
        return productService.registerNewProduct(categoryID,name,length,weight, height, price, numberinstock, location, timesshipped);
    }
    @CrossOrigin
    @GetMapping("/search/{searchText}")
    public List<Product> searchForProduct(@PathVariable String searchText){
       return productService.searchForProduct(searchText);

    }
    @CrossOrigin
    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable String id){
        int searchId= Integer.parseInt(id);
        return productService.findProductByID(searchId);

    }
    @CrossOrigin
    @PutMapping("/restock/{id}")
    public Product restockProduct(@RequestBody Map<String,Object>  updatedProduct,@PathVariable String id){
        int productID = Integer.parseInt(id);
        return productService.restockProduct(updatedProduct,productID);
    }
//    @CrossOrigin()
//    @GetMapping("{productID}/name")
//    public String getNameOfProduct(@PathVariable int productID){
//        return productService.findProductByID(productID).getName();
//    }

}
