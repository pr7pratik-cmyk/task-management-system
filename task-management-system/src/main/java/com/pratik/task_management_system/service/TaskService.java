package com.pratik.task_management_system.service;

import com.pratik.task_management_system.dto.TaskDto;
import com.pratik.task_management_system.exception.ResourceNotFoundException;
import com.pratik.task_management_system.model.Task;
import com.pratik.task_management_system.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, TaskDto dto){
        Task task = taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found"));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());

        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        if(!taskRepository.existsById(id)){
            throw new ResourceNotFoundException("Task not found");
        }
        taskRepository.deleteById(id);
    }

    public Page<Task> getTasks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return taskRepository.findAll(pageable);
    }

}