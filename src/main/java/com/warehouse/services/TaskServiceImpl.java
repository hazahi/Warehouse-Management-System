package com.warehouse.services;

import com.warehouse.model.ProductsForTask;
import com.warehouse.model.Task;
import com.warehouse.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProductsForTaskService productsForTaskService;
    @Autowired
    ProductService productService;

    public List<Task>getAllTasks(){
        return taskRepository.findAll();
    }

    public  Task getTaskWithId(int id){
        return taskRepository.getByTaskID(id);
    }
    public List<Task> getAllCompletedTasks(){
        return taskRepository.getAllByIsCompleteTrue();
    }
    public List<Task> getAllNotCompletedTasks() {
      return  taskRepository.getAllByIsCompleteFalse();
    }


    public int createTask(Map<String, Object> body) {
        String description=(String) body.get("description");
        int idAuthor = (int) body.get("taskAuthorID");
        Task task=new Task();
        task.setDescription(description);
        task.setTaskAuthor(idAuthor);
        task=taskRepository.save(task);
        return task.getTaskID();
    }

    public int createTask(Task task) {
        Task newTask= taskRepository.save(task);
        return newTask.getTaskID();
    }

    public boolean createProductListItemForTask(Map<String,Object> body, int taskID) {
        int amountToPrepare=Integer.parseInt((String) body.get("amount"));
        int productIDToPrepare=(int)body.get("productID");
        ProductsForTask newItem=new ProductsForTask();
        newItem.setTaskID(taskID);
        newItem.setAmount(amountToPrepare);
        newItem.setProductID(productIDToPrepare);
          ProductsForTask createdItem=productsForTaskService.saveProductForTask(newItem);
          if(createdItem.obtainEntryID()<=0){
              return false;
          }
          else {
              return true;
          }
    }

    public  Task completeTask( Map<String,Object> body, int taskID){
            int finisherID=(int)body.get("taskFinisherID");
        return taskRepository.findById(taskID).map(task -> {
            if(task.isComplete()){
                return task;
            }
            else{
                task.setComplete(true);
                task.setCompletionDate(LocalDateTime.now());
                task.setTaskFinisherID(finisherID);
                List<ProductsForTask>products=task.obtainProductsForTasks();
                for(ProductsForTask p:products){
                    productService.shipProduct(p.getAmount(),p.getProductID());
                }
                return taskRepository.save(task);
            }
        }).orElseGet(()->{
            return null;
        });
    }

    @Override
    public List<ProductsForTask> getProductsForTaskWithID(int taskID) {
        return productsForTaskService.getAllProductsForTaskWithID(taskID);
    }

    @Override
    public Task acceptTask(int taskID, Map<String,Object> body) {
        int employeeID=(int)body.get("employeeID");
        return taskRepository.findById(taskID).map(task->{
            if(task.getTaskFinisherID()<=0){
                task.setTaskFinisherID(employeeID);
                return taskRepository.save(task);
            }else{
                return null;
            }

        }).orElseGet(()->{
            return null;
        });
    }
}
