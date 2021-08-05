package com.warehouse.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void testGetName() {
        Product product=new Product();
        product.setName("John");
        Assert.assertEquals("John",product.getName());
    }

    @Test
    void testGetCategoryID() {
        Product product=new Product();
        product.setCategoryID(2);
        Assert.assertEquals(2,product.getCategoryID());
    }

    @Test
    void testGetSetLength() {
        Product product=new Product();
        product.setLength(23.5);
        Assert.assertEquals(23.5,product.getLength(),1);
    }

    @Test
    void testGetSetHeight() {
        Product product=new Product();
        product.setHeight(23.5);
        Assert.assertEquals(23.5,product.getHeight(),1);
    }

    @Test
    void testGetSetWeight() {
        Product product=new Product();
        product.setWeight(23.5);
        Assert.assertEquals(23.5,product.getWeight(),1);
    }

    @Test
    void testGetSetPrice() {
        Product product=new Product();
        product.setPrice(23.5);
        Assert.assertEquals(23.5 ,product.getPrice(),1);
    }

    @Test
    void testGetSetNumberInStock() {
        Product product=new Product();
        product.setNumberInStock(23);
        Assert.assertEquals(23,product.getNumberInStock());
    }

    @Test
    void testGetSetNumberShipped() {
        Product product=new Product();
        product.setNumberShipped(23);
        Assert.assertEquals(23,product.getNumberShipped());
    }

    @Test
    void testGetSetLocationInWarehouse() {
        Product product=new Product();
        product.setLocation("test");
        Assert.assertEquals("test",product.getLocationInWarehouse());
    }

}