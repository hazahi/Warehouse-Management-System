package com.warehouse.services;

import com.warehouse.model.ProductsForTask;
import com.warehouse.model.Task;

import java.util.List;
import java.util.Map;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskWithId(int taskID);
    List<Task> getAllCompletedTasks();
    List<Task> getAllNotCompletedTasks();
    int createTask(Map<String,Object> body);
    int createTask(Task task);
    boolean createProductListItemForTask(Map<String,Object> body, int taskID);
    Task completeTask(Map<String,Object> body,int taskD);

    List<ProductsForTask> getProductsForTaskWithID(int taskID);

    Task acceptTask(int taskID, Map<String,Object> body);
}
