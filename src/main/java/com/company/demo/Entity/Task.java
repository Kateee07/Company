package com.company.demo.Entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int id;
    private String name;
    private String description;
    private double estimateTime;
    @ManyToOne(cascade = CascadeType.ALL)
    private Status status;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Project project;
    @Nullable
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Employee employee;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WorkTime> workTimes;

    public Task(String name, String description, double estimateTime, Status status) {
        this.name = name;
        this.description = description;
        this.estimateTime = estimateTime;
        this.status = status;
    }

}

