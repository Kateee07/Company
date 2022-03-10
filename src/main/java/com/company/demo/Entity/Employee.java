package com.company.demo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Table(name = "employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private WorkPosition position;
    @JsonFormat(pattern = "MM-yyyy-dd", shape = JsonFormat.Shape.STRING, timezone = "CET")
    private LocalDate birthDate;
    private double salary;
    @JsonFormat(pattern = "MM-yyyy-dd", shape = JsonFormat.Shape.STRING, timezone = "CET")
    private LocalDate startWorkDate;
    private boolean target;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Address address;

    @Nullable
    @ManyToOne
    private Employee supervisor;
    private LocalDate endWorkDate;
    @Nullable
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            targetEntity = Project.class)
    @JoinTable(name = "em_pr", joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")}, inverseJoinColumns ={ @JoinColumn(name = "project_id", referencedColumnName = "project_id")})
    private Set<Project> projects = new HashSet<>();


    @Nullable
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Set<Task> tasks= new HashSet<>();


    public Employee(String name, String lastName, WorkPosition workPosition, LocalDate birthDate, double salary, LocalDate startWorkDate, boolean target, Address address, LocalDate endWorkDate) {
        this.name = name;
        this.lastName = lastName;
        this.position = workPosition;
        this.birthDate = birthDate;
        this.salary = salary;
        this.startWorkDate = startWorkDate;
        this.target = target;
        this.address=address;
        this.endWorkDate = endWorkDate;
    }

    public void addProject(Project project) {
        projects.add(project);
    }
    public  void addTask(Task task){
        tasks.add(task);
    }

    public int getAge() {
        Period period = Period.between(getBirthDate(), LocalDate.now());
        return period.getYears();
    }

    public double getBonus() {
        double bonus = 0;

        if (getPosition().getId() == 1) {
            bonus = getSalary() * position.getBonusToPosition();
        } else if (getPosition().getId() == 2) {
            bonus = getSalary() * position.getBonusToPosition();
        } else if (getPosition().getId() == 3) {
            bonus = getSalary() * position.getBonusToPosition();
        }

        return bonus;
    }


    public long getWorkPeriod() {
        long period = ChronoUnit.DAYS.between(getStartWorkDate(), LocalDate.now());
        return period;
    }

    public void increaseSalaryForEmployee(double increasePercantage) {
        salary = salary * increasePercantage;

    }


}
