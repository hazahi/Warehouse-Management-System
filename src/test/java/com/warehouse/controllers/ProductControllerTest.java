package com.warehouse.controllers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    int randomServerPort;

    @Test
    void testGetAllProducts() throws URISyntaxException {
        RestTemplate restTemplate=new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort + "/products/all";
        URI uri = new URI(baseUrl);
        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization","Basic dGVzdDp0ZXN0");
        HttpEntity entity=new HttpEntity(headers);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET ,entity,String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("categoryID"));
        Assert.assertEquals(true, result.getBody().contains("name"));
        Assert.assertEquals(true, result.getBody().contains("length"));
        Assert.assertEquals(true, result.getBody().contains("height"));
        Assert.assertEquals(true, result.getBody().contains("weight"));
        Assert.assertEquals(true, result.getBody().contains("price"));
        Assert.assertEquals(true, result.getBody().contains("numberInStock"));
        Assert.assertEquals(true, result.getBody().contains("locationInWarehouse"));
        Assert.assertEquals(true, result.getBody().contains("numberShipped"));
    }
    @Test
    void testSearchForProduct() throws URISyntaxException {
        RestTemplate restTemplate=new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort + "/products/search/MSI";
        URI uri = new URI(baseUrl);

        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization","Basic dGVzdDp0ZXN0");
        HttpEntity entity=new HttpEntity(headers);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET ,entity,String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("categoryID"));
        Assert.assertEquals(true, result.getBody().contains("name"));
        Assert.assertEquals(true, result.getBody().contains("length"));
        Assert.assertEquals(true, result.getBody().contains("height"));
        Assert.assertEquals(true, result.getBody().contains("weight"));
        Assert.assertEquals(true, result.getBody().contains("price"));
        Assert.assertEquals(true, result.getBody().contains("numberInStock"));
        Assert.assertEquals(true, result.getBody().contains("locationInWarehouse"));
        Assert.assertEquals(true, result.getBody().contains("numberShipped"));
    }
    @Test
    void testFindProductById() throws URISyntaxException {
        RestTemplate restTemplate=new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort + "/products/product/1";
        URI uri = new URI(baseUrl);

        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization","Basic dGVzdDp0ZXN0");
        HttpEntity entity=new HttpEntity(headers);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET ,entity,String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().contains("categoryID"));
        Assert.assertEquals(true, result.getBody().contains("name"));
        Assert.assertEquals(true, result.getBody().contains("length"));
        Assert.assertEquals(true, result.getBody().contains("height"));
        Assert.assertEquals(true, result.getBody().contains("weight"));
        Assert.assertEquals(true, result.getBody().contains("price"));
        Assert.assertEquals(true, result.getBody().contains("numberInStock"));
        Assert.assertEquals(true, result.getBody().contains("locationInWarehouse"));
        Assert.assertEquals(true, result.getBody().contains("numberShipped"));
    }
}