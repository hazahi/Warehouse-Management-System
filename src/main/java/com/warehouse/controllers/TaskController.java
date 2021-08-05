package com.warehouse.controllers;

import com.warehouse.model.ProductsForTask;
import com.warehouse.model.Task;
import com.warehouse.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @CrossOrigin
    @GetMapping("/all")
    public List<Task>getAllTasks(){
        return taskService.getAllTasks();
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id){
        return taskService.getTaskWithId(id);
    }
    @CrossOrigin
    @GetMapping("/completed")
    public List<Task>getAllCompletedTasks(){
        return taskService.getAllCompletedTasks();
    }
    @CrossOrigin
    @GetMapping("/pending")
    public List<Task>getAllNotCompletedTasks(){
        return taskService.getAllNotCompletedTasks();
    }
    @CrossOrigin
    @PutMapping("/{taskID}/complete")
    public Task completeTask(@RequestBody Map<String,Object> body,@PathVariable int taskID){
        return taskService.completeTask(body,taskID);
    }
    @CrossOrigin()
    @GetMapping("/{taskID}/products")
    public List<ProductsForTask>getProductsForTask(@PathVariable int taskID){
        return taskService.getProductsForTaskWithID(taskID);
    }
    @CrossOrigin
    @PostMapping("/createTask")
    public int createTask(@RequestBody Map<String,Object> body){
        return taskService.createTask(body);
    }
    @CrossOrigin
    @PostMapping("{taskID}/createList")
    public boolean createNewListForTaskWithID(@RequestBody Map<String,Object> body, @PathVariable int taskID){
        return taskService.createProductListItemForTask(body,taskID);

    }
    @CrossOrigin
    @PutMapping("{taskID}/accept")
    public Task acceptTask(@PathVariable int taskID,@RequestBody Map<String,Object> body){
        return taskService.acceptTask(taskID, body);
    }
}
