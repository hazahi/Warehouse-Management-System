package com.warehouse.repository;

import com.warehouse.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    Task getByTaskID(int taskID);
    List<Task>getAllByIsCompleteTrue();
    List<Task>getAllByIsCompleteFalse();
}
