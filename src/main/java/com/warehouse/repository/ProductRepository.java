package com.warehouse.repository;

import com.warehouse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

List<Product> findByNameContaining(String text);
Product findByProductID(int id);

}
