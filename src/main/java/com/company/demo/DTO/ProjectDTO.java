package com.company.demo.DTO;


import com.company.demo.Entity.Project;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProjectDTO {
    private Integer id;
    private String name;
    private int status;
    private LocalDate deadLine;
    private int priorityId;
    private List<Integer> employees;

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.status = project.getStatus().getId();
        this.deadLine = project.getDeadLine();
        this.priorityId = project.getPriority().getId();
        this.employees = project.getEmployees()
                .stream().map(c -> c.getId())
                .collect(Collectors.toList());


    }
}
