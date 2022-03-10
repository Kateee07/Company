package com.company.demo.DTO;

import com.company.demo.Entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(TaskDTO taskDTO) {
        Task task=new Task();
        return task;
    }

    public TaskDTO taskDTO(Task task) {
        TaskDTO taskDTO=new TaskDTO(task);
        return taskDTO;
    }
}
