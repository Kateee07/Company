package com.company.demo.Controllers;

import com.example.demo.DTO.ProjectDTO;
import com.example.demo.Services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewProject(@RequestParam String name, @RequestParam int statusID, @RequestParam LocalDate localDate, @RequestParam int priorityID) {
        projectService.create(name, statusID, localDate, priorityID);

    }

    @RequestMapping(value = "/addEmployeeToProject", method = RequestMethod.POST)
    public void addEmployee(int projectId, int employeeId) {
        projectService.addEmployeeToProject(projectId, employeeId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void editProject(int id, LocalDate date) {
        projectService.updateProject(id, date);
    }

    @RequestMapping(value = "saveStatus", method = RequestMethod.POST)
    public void saveStatus(int id, int status) {
        projectService.saveStatus(id, status);
    }

    @GetMapping("/finished")
    public List<ProjectDTO> finishedProject() {
        return projectService.getFinishedProject();
    }

    @GetMapping("/actual")
    public List<ProjectDTO> actualProject() {
        return projectService.getActualProject();
    }

    @DeleteMapping("/delete")
    public HttpStatus deleteProject(int id) {
        return projectService.deleteProject(id);
    }

    @RequestMapping(value = "/disableProject}", method = RequestMethod.POST)
    public void disablePro(int id) {
        projectService.disableProject(id);
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public void addTask(int projectId, String name, String description, double estimateTime) {
        projectService.addTask(projectId, name, description, estimateTime);
    }

    @GetMapping("/findProjectById/{id}")
    public ProjectDTO findProjectById(@PathVariable int id) {
        return projectService.findProjectById(id);
    }
}
