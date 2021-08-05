package com.warehouse.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="preptask")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskID;

    private int taskAuthorID;

    @Column(insertable = false,updatable = true,nullable = true)
    private int taskFinisherID;

    private String description;

    private boolean isComplete;

    @OneToMany(targetEntity = ProductsForTask.class)
    @JoinColumn(name="taskID",insertable = false,updatable = false)
    private List<ProductsForTask> productsForTasks;

    private LocalDateTime completionDate;
    public Task(int taskID,int taskAuthorID,int taskFinisherID,String description,boolean isComplete){
        this.taskID=taskID;
        this.taskAuthorID=taskAuthorID;
        this.taskFinisherID=taskFinisherID;
        this.description=description;
        this.isComplete=isComplete;

    }
    public Task(){

    }
    public int getTaskAuthorID() {
        return taskAuthorID;
    }

    public int getTaskFinisherID() {
        return taskFinisherID;
    }

    public List<ProductsForTask> obtainProductsForTasks() {
        return productsForTasks;
    }

    public int getTaskID() {
        return taskID;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void setTaskFinisherID(int taskFinisherID) {
        this.taskFinisherID = taskFinisherID;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTaskAuthor(int taskAuthorID) {
        this.taskAuthorID = taskAuthorID;
    }

    public void setProductsForTasks(List<ProductsForTask> productsForTasks) {
        this.productsForTasks = productsForTasks;
    }

    public void setTaskFinisher(int taskFinisherID) {
        this.taskFinisherID = taskFinisherID;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID=" + taskID +
                ", taskAuthorID=" + taskAuthorID +
                ", taskFinisherID=" + taskFinisherID +
                ", description='" + description + '\'' +
                ", isComplete=" + isComplete +
                ", productsForTasks=" + productsForTasks +
                ", completionDate=" + completionDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return getTaskID() == task.getTaskID() &&
                getTaskAuthorID() == task.getTaskAuthorID() &&
                isComplete() == task.isComplete() &&
                Objects.equals(getTaskFinisherID(), task.getTaskFinisherID()) &&
                Objects.equals(getDescription(), task.getDescription()) &&
                Objects.equals(getCompletionDate(), task.getCompletionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaskID(), getTaskAuthorID(), getTaskFinisherID(), getDescription(), isComplete(), getCompletionDate());
    }
}
