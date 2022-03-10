package com.company.demo.Controllers;



import com.example.demo.Repositories.ProjectRepository;
import com.example.demo.Services.RandomDatabase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/random")
public class RandomDatabaseController {
    RandomDatabase randomDatabase;
    ProjectRepository projectRepository;

    public RandomDatabaseController(RandomDatabase randomDatabase, ProjectRepository projectRepository) {
        this.randomDatabase = randomDatabase;
        this.projectRepository = projectRepository;
    }

    @PostMapping("/init")
    public void init() {
        randomDatabase.init();
    }

    @PostMapping("/employee")
    public void getRandomPersons() {
        randomDatabase.getRandomEmployee();
    }

    @PostMapping("/projects")
    public void getRandomProjects() {
        randomDatabase.getRandomProjects();
    }

    @PostMapping("/adress")
    public void getRandomAddress() {
        randomDatabase.getRandomAdress();
    }
    @PostMapping("/tasks")
    public void getRandomTask() {
        randomDatabase.getRandomTask();
    }
    @PostMapping("/addTaskToProject")
    public void addTaskToProject(){
        randomDatabase.addTaskToProject();
    }
    @PostMapping("/addAdressToEmployee")
    public void addAdressToEmployee(){
        randomDatabase.addAdressToEmployee();
    }
    @PostMapping("/addEmployeeToProject")
    public void addEmployeeToProject(){
        randomDatabase.addEmployeeToProject();
    }

    @PostMapping("/addEmployeeToProject2")
    public void addEmployeeToProject2(){
        randomDatabase.addEmployeeToProject2();

    }
}
