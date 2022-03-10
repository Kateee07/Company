package com.company.demo.Controllers;

import com.example.demo.Entity.Task;
import com.example.demo.Repositories.EmployeeRepository;
import com.example.demo.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SQLQueryController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    TaskRepository taskRepository;

    public SQLQueryController(EmployeeRepository employeeRepository, TaskRepository taskRepository) {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/sumOfSalaryAllEmployee")
    public double sumOfSalaryAllEmployees(){
        return employeeRepository.getSumOfSalaryAllEmployee();
    }
    @GetMapping("/sumOfSalaryWorkes")
    public double sumOfSalaryWorkers(){
        return employeeRepository.getSumOFSalaryWorkers();
    }
    @GetMapping("/sumOfSalaryManagers")
    public double sumOfSalaryManagers(){
        return employeeRepository.getSumOFSalaryManagers();
    }
    @GetMapping("/sumOfSalaryDirectors")
    public double sumOfSalaryDirectors(){
        return employeeRepository.getSumOFSalaryDirectors();
    }
    @GetMapping("/avgSalaryAllEmployee")
    public double avgSalaryAllEmployees(){
        return employeeRepository.getAvgSalaryAllEmployee();
    }
    @GetMapping("/avgSalaryWorkes")
    public double avgSalaryWorkers(){
        return employeeRepository.getAvgSalaryWorkers();
    }
    @GetMapping("/avgSalaryManagers")
    public double avgSalaryManagers(){
        return employeeRepository.getAvgSalaryManagers();
    }
    @GetMapping("/avgSalaryDirectors")
    public double avgSalaryDirectors(){
        return employeeRepository.getAvgSalaryDirectors();
    }


    @GetMapping("tasksList")
    public List<Task> tasksInProgress() {
        return taskRepository.taskList();
    }
    @GetMapping("tasksListInProgressForEmployee")
    public List<Task> tasksInProgressForEmployee(int id){
        return taskRepository.inProgressTaskForEmployeeById(id);
    }
    @GetMapping("tasksListInProgressForProject")
    public List<Task> tasksInProgressForProject(int id){
        return taskRepository.inProgressTaskListForProjectById(id);
    }
    @GetMapping("taskListWhenProjectIsFinished")
    public List<Task> taskListWhenProjectIsFinished(int projectId){
        return taskRepository.taskListWhenProjectIsFinished(projectId);
    }
    @GetMapping("taskListForProjectPriority")
    public List<Task> taskListForProjectPriority(int priorityId) {
        return taskRepository.taskListByProjectPriority(priorityId);
    }
    @GetMapping("listOfTaskWhereWorkTimeIsBiggerThanEstimationTimeByTheProject")
    public List<Task> listOfTaskWhereWorkTimeIsBiggerThanEstimationTimeByTheProject(int projectId){
        return taskRepository.listOfTaskWhereWorkTimeIsBiggerThanEstimationTimeByTheProject(projectId);
    }
    @GetMapping("listOfTaskWhereWorkTimeIsBiggerThanEstimationTimeByTheEmployee")
    public List<Task> listOfTaskWhereWorkTimeIsBiggerThanEstimationTimeByTheEmployee(int employeeId){
        return taskRepository.listOfTaskWhereWorkTimeIsBiggerThanEstimationTimeByTheEmployee(employeeId);
    }







}
