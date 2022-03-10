package com.company.demo.DTO;



import com.company.demo.Entity.Employee;
import com.company.demo.Entity.WorkPosition;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Data

public class EmployeeDTO {
    private Integer id;
    private String name;
    private String lastName;
    private WorkPosition position;
    private LocalDate birthDate;
    private double salary;
    private LocalDate startWorkDate;
    private boolean target;
    private int supervisorID;
    private LocalDate endWorkDate;
    private List<Integer> projects;
    private List<Integer> taskID;
    private int addressId;


    public EmployeeDTO(Employee employee) {
        this.id =employee.getId();
        this.name = employee.getName();
        this.lastName = employee.getLastName();
        this.position = employee.getPosition();
        this.birthDate = employee.getBirthDate();
        this.salary = employee.getSalary();
        this.startWorkDate = employee.getStartWorkDate();
        this.target = employee.isTarget();
        if(employee.getSupervisor() != null){
            this.supervisorID= employee.getSupervisor().getId();
        }
        this.addressId=employee.getAddress().getId();
        this.endWorkDate = employee.getEndWorkDate();
        this.projects = employee.getProjects().stream().map(c -> c.getId()).collect(Collectors.toList());
        this.taskID= employee.getTasks().stream().map(c->c.getId()).collect(Collectors.toList());
    }

}
