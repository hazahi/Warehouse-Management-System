package com.warehouse.repository;

import com.warehouse.model.ProductsForTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsForTaskRepository extends JpaRepository<ProductsForTask,Integer> {
    List<ProductsForTask>getAllByTaskID(int taskID);
}
