package com.company.demo.Services;


import com.company.demo.DTO.TaskDTO;
import com.company.demo.DTO.TaskMapper;
import com.company.demo.DTO.WorkTimeDTO;
import com.company.demo.DTO.WorkTimeMapper;
import com.company.demo.Entity.*;
import com.company.demo.Repositories.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class TaskService {
    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;
    private EmployeeRepository employeeRepository;
    private TaskMapper taskMapper;
    private WorktimeRepository worktimeRepository;
    private StatusRepository statusRepository;
    private PriorityRepository priorityRepository;
    private WorkTimeMapper workTimeMapper;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository, EmployeeRepository employeeRepository, TaskMapper taskMapper, WorktimeRepository worktimeRepository, StatusRepository statusRepository, PriorityRepository priorityRepository, WorkTimeMapper workTimeMapper) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
        this.taskMapper = taskMapper;
        this.worktimeRepository = worktimeRepository;
        this.statusRepository = statusRepository;
        this.priorityRepository = priorityRepository;
        this.workTimeMapper = workTimeMapper;
    }

    public Task createTask(String name, String description, double estimateTime) {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setEstimateTime(estimateTime);
        taskRepository.save(task);
        return task;

    }

    public void assignEmployeeToTask(int employeeId, int taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        int id = task.getProject().getId();
        for (Project project : employee.getProjects()) {
            if (project.getId() == id) {
                task.setEmployee(employee);
            }
        }
        taskRepository.save(task);
        Set<Task> tasks = employee.getTasks();
        tasks.add(task);
        employee.setTasks(tasks);
        employeeRepository.save(employee);
    }

    public void logWorkTime(int taskId, LocalDate date, double timeOfWork, String description, int statusId, int priorityId, int employeeId) {
        Task task1 = taskRepository.findById(taskId).orElse(null);
        WorkTime workTime = new WorkTime();
        workTime.setDate(date);
        workTime.setTimeOfWork(timeOfWork);
        workTime.setDescription(description);
        Priority priority = priorityRepository.findById(priorityId).orElse(null);
        workTime.setPriority(priority);
        Status status = statusRepository.findById(statusId).orElse(null);
        workTime.setStatus(status);
        workTime.setTask(task1);
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            throw new NullPointerException("Need Employee ID");
        } else {
            workTime.setEmployee(employee);
        }
        workTime.setInsDate(LocalDate.now());
        worktimeRepository.save(workTime);
        task1.setWorkTimes(worktimeRepository.findAll().stream().filter(c -> c.getTask().getId() == taskId).collect(Collectors.toSet()));
        taskRepository.save(task1);
    }


    public void editTask(int taskId, double exstraWorkTime) {
        Task task = taskRepository.findById(taskId).orElse(null);
        double timeOfWork = 0;
        for (WorkTime workTime : task.getWorkTimes()) {
            if (workTime.getTask().getId() == taskId) {
                timeOfWork = workTime.getTimeOfWork();
                workTime.setTimeOfWork(timeOfWork + exstraWorkTime);
                worktimeRepository.save(workTime);
                task.getWorkTimes().add(workTime);
            }
            taskRepository.save(task);
        }
    }

    public List<TaskDTO> getListofTaskByProjectId(int projectId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        Set<Task> tasks = project.getTasks();
        List<TaskDTO> dtoList = tasks.stream()
                .map(c -> taskMapper.taskDTO(c))
                .collect(Collectors.toList());
        return dtoList;
    }

    public List<WorkTimeDTO> getLsitOfWorkTimeByTask(int taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        Set<WorkTime> workTimes = task.getWorkTimes();
        List<WorkTimeDTO> workTimeDTOS = workTimes.stream().
                map(a -> workTimeMapper.workTimeDTO(a))
                .collect(Collectors.toList());
        return workTimeDTOS;
    }

    public void changeEmployeeToTask(int employee2ID, int taskID) {
        Employee employee2 = employeeRepository.findById(employee2ID).orElse(null);
        Task task = taskRepository.findById(taskID).orElse(null);
        task.setEmployee(employee2);
        Set<Task> tasks = employee2.getTasks();
        tasks.add(task);
        employeeRepository.save(employee2);
    }

}
