package com.warehouse.services;

import com.warehouse.WarehouseApplication;
import com.warehouse.model.Product;
import com.warehouse.model.Restock;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.RestockHistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import static org.assertj.core.api.Assertions.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WarehouseApplication.class)
class ProductServiceImplTest {



    @Autowired
    private RestockHistoryService restockHistoryService;

    @MockBean
    private RestockHistoryRepository restockHistoryRepository;

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @TestConfiguration
    static class ProductServiceImplTestContextConfiguration{
        @Bean
        public RestockHistoryService restockHistoryService(){
            return new RestockHistoryServiceImpl();
        }
        @Bean
        public ProductService productService(){
            return new ProductServiceImpl();
        }

    }

    @BeforeEach
    void setUp() {
        Product product1=new Product(1,"Test 1",2,2,2,2,23,"Test location 1",23);
        Product product2=new Product(1,"Test 2",2,2,2,2,23,"Test location 2",23);
        product1.setProductID(1);
        product2.setProductID(2);
        List<Product> products=new ArrayList<>();
        products.add(product1);
        products.add(product2);
        List<Product>productSearchList=new ArrayList<>();
        productSearchList.add(product2);
        Mockito.when(productRepository.findAll()).thenReturn(products);
        Mockito.when(productRepository.findByNameContaining("2")).thenReturn(productSearchList);
        Mockito.when(productRepository.findByProductID(1)).thenReturn(product1);
        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(product1));
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenAnswer(i -> i.getArguments()[0]);
        Mockito.when(restockHistoryRepository.save(Mockito.any(Restock.class))).thenAnswer(i -> i.getArguments()[0]);
    }

    @Test
    void getAllProducts() {
        List<Product> productsFromRepo=productService.getAllProducts();
        Product product1=new Product(1,"Test 1",2,2,2,2,23,"Test location 1",23);
        Product product2=new Product(1,"Test 2",2,2,2,2,23,"Test location 2",23);
        List<Product> products=new ArrayList<>();
        product1.setProductID(1);
        product2.setProductID(2);
        products.add(product1);
        products.add(product2);
        assertThat(products).isEqualTo(productsFromRepo);
    }


    @Test
    void searchForProduct() {
        List<Product>searchResults=productService.searchForProduct("2");
        Product product=new Product(1,"Test 2",2,2,2,2,23,"Test location 2",23);
        product.setProductID(2);
        assertThat(searchResults.get(0)).isEqualTo(product);
    }

    @Test
    void findProductByID() {
        Product found=productService.findProductByID(1);
        Product product1=new Product(1,"Test 1",2,2,2,2,23,"Test location 1",23);
        product1.setProductID(1);
        assertThat(found).isEqualTo(product1);
    }

    @Test
    void restockProduct() {
        Map<String,Object>updatedProduct=new HashMap<>();
        int updateAmountValue=2;
        int updateEmployeeID=3;
        updatedProduct.put("employeeID",updateEmployeeID);
        updatedProduct.put("amountRestocked",updateAmountValue);
        Product product1=new Product(1,"Test 1",2,2,2,2,23+updateAmountValue,"Test location 1",23);
        product1.setProductID(1);
        Product product=productService.restockProduct(updatedProduct,1);
        assertThat(product1).isEqualTo(product);
    }

    @Test
    void shipProduct() {
        Map<String,Object>updatedProduct=new HashMap<>();
        int updateShippedValue=2;
        updatedProduct.put("numberShipped",updateShippedValue);
        Product product1=new Product(1,"Test 1",2,2,2,2,23-updateShippedValue,"Test location 1",23+updateShippedValue);
        product1.setProductID(1);
        Product shippedProduct=productService.shipProduct(updatedProduct,"1");
        assertThat(product1).isEqualTo(shippedProduct);
    }
}