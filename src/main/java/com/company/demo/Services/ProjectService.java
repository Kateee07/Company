package com.company.demo.Services;

import com.company.demo.DTO.ProjectDTO;
import com.company.demo.DTO.ProjectMapper;
import com.company.demo.Entity.Employee;
import com.company.demo.Entity.Project;
import com.company.demo.Entity.Status;
import com.company.demo.Entity.Task;
import com.company.demo.Repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    ProjectRepository projectRepository;
    EmployeeRepository employeeRepository;
    PriorityRepository priorityRepository;
    StatusRepository statusRepository;
    ProjectMapper projectMapper;
    TaskRepository taskRepository;
    TaskService taskService;

    public ProjectService(ProjectRepository projectRepository, EmployeeRepository employeeRepository, PriorityRepository priorityRepository, StatusRepository statusRepository, ProjectMapper projectMapper, TaskRepository taskRepository, TaskService taskService) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
        this.priorityRepository = priorityRepository;
        this.statusRepository = statusRepository;
        this.projectMapper = projectMapper;
        this.taskRepository = taskRepository;
        this.taskService = taskService;
    }

    public void create(String name, int statusID, LocalDate localDate, int priorityID) {
        Project project = new Project();
        project.setName(name);
        project.setStatus(statusRepository.findById(statusID).orElse(null));
        project.setDeadLine(localDate);
        project.setPriority(priorityRepository.findById(priorityID).orElse(null));
        projectRepository.save(project);
    }

    public void addEmployeeToProject(int projectId, int employeeId) {
        Employee employeeByID = employeeRepository.findEmployeeByID(employeeId);
        Project project = projectRepository.findProjectById(projectId);
        Set<Employee> employees = project.getEmployees();
        employees.add(employeeByID);
        project.setEmployees(employees);
        Set<Project> projects = employeeByID.getProjects();
        projects.add(project);
        employeeByID.setProjects(projects);
        employeeRepository.save(employeeByID);
        projectRepository.save(project);
    }

    public List<ProjectDTO> getActualProject() {
        List<ProjectDTO> actual = projectRepository.getActualProjectList().stream()
                .map(c -> projectMapper.toDTO(c))
                .collect(Collectors.toList());
        return actual;
    }

    public List<ProjectDTO> getFinishedProject() {
        List<Project> finished = projectRepository.getFinishedProjects();
        return finished.stream() .map(c -> projectMapper.toDTO(c)).collect(Collectors.toList());
    }

    public void updateProject(int id, LocalDate deadline) {
        Project project = projectRepository.findProjectById(id);
        project.setDeadLine(deadline);
        projectRepository.save(project);

    }
    public void saveStatus(int id, int statusId) {
        Status status = statusRepository.findById(statusId).orElse(null);
        Project project = projectRepository.findProjectById(id);
        project.setStatus(status);
        projectRepository.save(project);
    }

    public HttpStatus deleteProject(Integer id) {
        Project project = projectRepository.findProjectById(id);
        if (CollectionUtils.isEmpty(project.getEmployees())) {
            projectRepository.delete(project);
            return HttpStatus.OK;
        } else
            return HttpStatus.NOT_ACCEPTABLE;

    }

    public void disableProject(int id) {
        Project project = projectRepository.findProjectById(id);
        Set<Task> tasks = project.getTasks();
        tasks.forEach(c -> c.setDescription("Task is done because project is done"));
        tasks.forEach(c -> c.getWorkTimes().stream().forEach(a -> a.setStatus(statusRepository.findById(2).orElse(null))));

        List<Employee> employeeWithProject = employeeRepository.findEmployeeFromProject(id);
        for (Employee employee : employeeWithProject) {
        employee.setProjects(null);
        employeeRepository.save(employee); }

        project.setEmployees(null);
        projectRepository.save(project);
    }

    public void addTask(int projectId, String name, String description, double estimateTime) {
        Task task = taskService.createTask(name, description, estimateTime);
        Project project = projectRepository.findProjectById(projectId);
        Set<Task> tasks = project.getTasks();
        tasks.add(task);
        project.setTasks(tasks);
        task.setProject(project);
        taskRepository.save(task);
        projectRepository.save(project);
    }

    public ProjectDTO findProjectById(int id){
        Project projectById = projectRepository.findProjectById(id);
        return projectMapper.toDTO(projectById);
    }


}
