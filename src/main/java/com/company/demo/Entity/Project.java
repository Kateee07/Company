package com.company.demo.Entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Table(name = "project")
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer id;
    private String name;
    @Nullable
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private  Status status;
    private LocalDate deadLine;
    @Nullable
    @ManyToOne(cascade = CascadeType.ALL)
    private Priority priority;
    @Nullable
    @ManyToMany( fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "projects", targetEntity = Employee.class)
    private Set<Employee>employees= new HashSet<>();

    @Nullable
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Set<Task> tasks= new HashSet<>();

    public Project(String name, Status status, LocalDate deadLine, Priority priority) {
        this.name = name;
        this.status = status;
        this.deadLine = deadLine;
        this.priority = priority;
    }

    public void employee(Employee employee){
        employees.add(employee);
    }
    public void addTask(Task task){
        tasks.add(task);
    }
}
