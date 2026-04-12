package com.pratik.task_management_system.controller;

import com.pratik.task_management_system.dto.TaskDto;
import com.pratik.task_management_system.model.Task;
import com.pratik.task_management_system.payload.ApiResponse;
import com.pratik.task_management_system.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public ApiResponse<Task> createTask(@Valid @RequestBody TaskDto dto){
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        Task saved = taskService.createTask(task);
        return new ApiResponse<>("Task created successfully", saved);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @Valid @RequestBody TaskDto dto){
        return taskService.updateTask(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }

    @GetMapping("/page")
    public Page<Task> getTask(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5")int size){
        return taskService.getTasks(page, size);
    }
}