package com.company.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class WorkTime {
    @Id
    @GeneratedValue
    @Column(name = "workTime_id")
    private int id;
    private LocalDate date;
    private double timeOfWork;
    private String description;
    @ManyToOne
    private Status status;
    @ManyToOne
    private Priority priority;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne
    private Employee employee;

    private LocalDate insDate;

}
