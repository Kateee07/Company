package com.company.demo.DTO;

import com.company.demo.Entity.Task;
import lombok.Data;


@Data
public class TaskDTO {
    private int id;
    private String name;
    private String description;
    private double estimateTime;
    private int projectId;
    private int employeeId;
    private int statusId;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.estimateTime = task.getEstimateTime();
        this.projectId = task.getProject().getId();
        this.employeeId = task.getEmployee().getId();
        this.statusId= task.getStatus().getId();
    }
}
