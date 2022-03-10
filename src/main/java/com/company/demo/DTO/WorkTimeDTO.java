package com.company.demo.DTO;

import com.company.demo.Entity.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkTimeDTO {
    private int id;
    private LocalDate date;
    private double timeOfWork;
    private String description;
    private int statusID;
    private int priorityID;
    private int taskID;
    private int employeeID;
    private LocalDate insDate;

    public WorkTimeDTO(WorkTime workTime) {
        this.id = workTime.getId();
        this.date = workTime.getDate();
        this.timeOfWork = workTime.getTimeOfWork();
        this.description = workTime.getDescription();
        this.statusID = workTime.getStatus().getId();
        this.priorityID=workTime.getPriority().getId();
        this.taskID=workTime.getTask().getId();
        this.employeeID= workTime.getEmployee().getId();
        this.insDate= LocalDate.now();
    }
}
