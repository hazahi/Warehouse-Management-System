package com.warehouse.services;

import com.warehouse.WarehouseApplication;
import com.warehouse.model.Product;
import com.warehouse.model.ProductsForTask;
import com.warehouse.model.Restock;
import com.warehouse.model.Task;
import com.warehouse.repository.ProductsForTaskRepository;
import com.warehouse.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WarehouseApplication.class)
class TaskServiceImplTest {
    @TestConfiguration
    static class TaskServiceImplTestContextConfiguration{
        @Bean
        public TaskService taskService(){
            return new TaskServiceImpl();
        }
        @Bean
        public ProductsForTaskService productsForTaskService(){
            return new ProductsForTaskServiceImpl();
        }
    }
    @Autowired
    TaskService taskService;
    @Autowired
    ProductsForTaskService productsForTaskService;
    @MockBean
    TaskRepository taskRepository;
    @MockBean
    ProductsForTaskRepository productsForTaskRepository;

    @BeforeEach
    void setUp() {
        Product product1=new Product(1,"Testing 1",2,2,2,2,23,"Test location 1",23);
        product1.setProductID(1);
        Product product2=new Product(1,"Testing 1",2,2,2,2,23,"Test location 1",23);
        product2.setProductID(2);
        ProductsForTask productListItem1=new ProductsForTask(1,1,1,23,product1);
        ProductsForTask productListItem2=new ProductsForTask(1,1,2,23,product2);
        List<ProductsForTask>productsForTask1=new ArrayList<>();
        productsForTask1.add(productListItem1);
        productsForTask1.add(productListItem2);
        ProductsForTask productListItem3=new ProductsForTask(1,2,1,23,product1);
        ProductsForTask productListItem4=new ProductsForTask(1,2,2,23,product2);
        List<ProductsForTask>productsForTask2=new ArrayList<>();
        productsForTask2.add(productListItem3);
        productsForTask2.add(productListItem4);
        Task task1=new Task(1,1,2,"test",true);
        Task task2=new Task(2,1,0,"test 2",false);
        task1.setProductsForTasks(productsForTask1);
        task2.setProductsForTasks(productsForTask2);
        List<Task>tasks=new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        List<Task>completedTasks=new ArrayList<>();
        completedTasks.add(task1);
        Mockito.when(taskRepository.findAll()).thenReturn(tasks);
        Mockito.when(taskRepository.getByTaskID(1)).thenReturn(task1);
        Mockito.when(taskRepository.getByTaskID(2)).thenReturn(task2);
        Mockito.when(taskRepository.getAllByIsCompleteTrue()).thenReturn(completedTasks);
        Mockito.when(taskRepository.findById(2)).thenReturn(Optional.of(task2));
        Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenAnswer(i -> i.getArguments()[0]);
    }


    @Test
    void getTaskWithId() {
        Product product1=new Product(1,"Testing 1",2,2,2,2,23,"Test location 1",23);
        product1.setProductID(1);
        Product product2=new Product(1,"Testing 1",2,2,2,2,23,"Test location 1",23);
        product2.setProductID(2);
        ProductsForTask productListItem1=new ProductsForTask(1,1,1,23,product1);
        ProductsForTask productListItem2=new ProductsForTask(1,1,2,23,product2);
        List<ProductsForTask>productsForTask1=new ArrayList<>();
        productsForTask1.add(productListItem1);
        productsForTask1.add(productListItem2);
        Task task1=new Task(1,1,2,"test",true);
        task1.setProductsForTasks(productsForTask1);
        Task foundTask=taskService.getTaskWithId(1);
        assertThat(task1).isEqualTo(foundTask);
    }

    @Test
    void getAllCompletedTasks() {
        Product product1=new Product(1,"Testing 1",2,2,2,2,23,"Test location 1",23);
        product1.setProductID(1);
        Product product2=new Product(1,"Testing 1",2,2,2,2,23,"Test location 1",23);
        product2.setProductID(2);
        ProductsForTask productListItem1=new ProductsForTask(1,1,1,23,product1);
        ProductsForTask productListItem2=new ProductsForTask(1,1,2,23,product2);
        List<ProductsForTask>productsForTask1=new ArrayList<>();
        productsForTask1.add(productListItem1);
        productsForTask1.add(productListItem2);
        Task task1=new Task(1,1,2,"test",true);
        task1.setProductsForTasks(productsForTask1);
        List<Task>completedTasks=new ArrayList<>();
        completedTasks.add(task1);
        List<Task>foundCompletedTasks=taskService.getAllCompletedTasks();
        assertThat(completedTasks).isEqualTo(foundCompletedTasks);
    }

    @Test
    void completeTask() {
        Map<String,Object>completedTask=new HashMap<>();
        int taskFinisherID=2;
        completedTask.put("taskFinisherID",taskFinisherID);
        Product product1=new Product(1,"Testing 1",2,2,2,2,23,"Test location 1",23);
        product1.setProductID(1);
        Product product2=new Product(1,"Testing 1",2,2,2,2,23,"Test location 1",23);
        product2.setProductID(2);
        ProductsForTask productListItem3=new ProductsForTask(1,2,1,23,product1);
        ProductsForTask productListItem4=new ProductsForTask(1,2,2,23,product2);
        List<ProductsForTask>productsForTask2=new ArrayList<>();
        productsForTask2.add(productListItem3);
        productsForTask2.add(productListItem4);
        Task task2=new Task(2,1,2,"test 2",true);
        task2.setProductsForTasks(productsForTask2);
        Task updatedTask=taskService.completeTask(completedTask,2);
        assertThat(task2.getTaskID()).isEqualTo(updatedTask.getTaskID());
        assertThat(task2.getTaskFinisherID()).isEqualTo(updatedTask.getTaskFinisherID());
        assertThat(task2.isComplete()).isEqualTo(updatedTask.isComplete());
    }
}