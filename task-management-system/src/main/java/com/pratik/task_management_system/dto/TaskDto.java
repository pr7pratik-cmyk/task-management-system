package com.pratik.task_management_system.dto;

import com.pratik.task_management_system.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskDto {
    @NotBlank(message = "Title is required")
    private String title;
    @Size(min = 5,max = 200,message = "Description must be 5-200 characters")
    private String description;
    @NotNull(message = "Status is required")
    private TaskStatus status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
