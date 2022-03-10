package com.company.demo.Controllers;
import com.example.demo.DTO.TaskDTO;
import com.example.demo.DTO.WorkTimeDTO;
import com.example.demo.Services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/asignEmployee")
    public void assignEmployee( int employeeId, int taskId) {
        taskService.assignEmployeeToTask(employeeId, taskId);
    }

    @PostMapping("/addWorkTime")
    public void addWorkTime( int taskId, LocalDate date, double timeOfWork, String description, int statusId, int priorityId, int employeeId) {
        taskService.logWorkTime(taskId, date, timeOfWork, description, statusId, priorityId, employeeId);
    }

    @PutMapping("/editWorkTime")
    public void editWorkTime(int taskId, double extraWorkTime){
        taskService.editTask(taskId,extraWorkTime);
    }

    @GetMapping("/getListOfTaskByProjectId/{projectId}")
    public List<TaskDTO> getListOfTaskByProjectId(@PathVariable int projectId){
       return taskService.getListofTaskByProjectId(projectId);
    }

    @GetMapping("showListOfWorkTimeToTask/{taskId}")
    public List<WorkTimeDTO> getListOfWorkTime(@PathVariable int taskId){
        return taskService.getLsitOfWorkTimeByTask(taskId);
    }

    @PostMapping("/fireAndAddNewEmployeeToTask")
    public void deleteEmployeeFromTaskAndAddNew(int employee2Id, int taskId){
        taskService.changeEmployeeToTask(employee2Id,taskId);
    }

}
