package com.warehouse.repository;

import com.warehouse.model.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testProductRepository(){
        Product product=new Product();
        product.setName("UTest");
        product.setCategoryID(2);
        product.setHeight(23);
        product.setLength(23);
        product.setWeight(23);
        product.setLocation("Test location");
        product.setNumberInStock(23);
        product.setPrice(23);
        product.setNumberShipped(23);

        productRepository.save(product);
        Assert.assertNotNull(product.getProductID());
    }
}