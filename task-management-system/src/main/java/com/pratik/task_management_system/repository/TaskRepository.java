package com.pratik.task_management_system.repository;

import com.pratik.task_management_system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
