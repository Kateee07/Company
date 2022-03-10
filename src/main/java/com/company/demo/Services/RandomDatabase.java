package com.company.demo.Services;

import com.company.demo.Entity.*;
import com.company.demo.Projections.EmployeeView;
import com.company.demo.Repositories.*;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class RandomDatabase {
    private ProjectRepository projectRepository;
    private AdressRepository adressRepository;
    private TaskRepository taskRepository;
    private EmployeeRepository employeeRepository;
    private PriorityRepository priorityRepository;
    private PositionRepository positionRepository;
    private StatusRepository statusRepository;

    public RandomDatabase(ProjectRepository projectRepository, AdressRepository adressRepository, TaskRepository taskRepository, EmployeeRepository employeeRepository, PriorityRepository priorityRepository, PositionRepository positionRepository, StatusRepository statusRepository) {
        this.projectRepository = projectRepository;
        this.adressRepository = adressRepository;
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.priorityRepository = priorityRepository;
        this.positionRepository = positionRepository;
        this.statusRepository = statusRepository;
    }


    Faker faker = new Faker();
    Random rand = new Random();


    public void init() {
        positionRepository.saveAndFlush(new WorkPosition(1, "Worker"));
        positionRepository.saveAndFlush(new WorkPosition(2, "Manager"));
        positionRepository.saveAndFlush(new WorkPosition(3, "Director"));
        positionRepository.saveAndFlush(new WorkPosition(4, "Head"));

        List<WorkPosition> all = positionRepository.findAll();
        System.out.println(all);

        priorityRepository.saveAndFlush(new Priority(1, "Low"));
        priorityRepository.saveAndFlush(new Priority(2, "Medium"));
        priorityRepository.saveAndFlush(new Priority(3, "High"));
        priorityRepository.saveAndFlush(new Priority(4, "Critical"));

        statusRepository.saveAndFlush(new Status(1, "Inprogress"));
        statusRepository.saveAndFlush(new Status(2, "Done"));
        statusRepository.saveAndFlush(new Status(3, "New"));
    }


    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomBirthDate() {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(1960, 2000);
        return LocalDate.of(year, month, day);

    }

    public static LocalDate createRandomStartWorkDate() {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(2000, 2021);
        return LocalDate.of(year, month, day);

    }

    public static LocalDate createRandomEndWorkDate() {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(2021, 2030);
        return LocalDate.of(year, month, day);
    }

    public void getRandomEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Employee employee = new Employee();
            employee.setLastName(faker.name().lastName());
            employee.setName(faker.name().firstName());
            employee.setBirthDate(createRandomBirthDate());
            employee.setSalary(faker.number().numberBetween(1000, 20000));
            employee.setStartWorkDate(createRandomStartWorkDate());
            employee.setEndWorkDate(createRandomEndWorkDate());
            employee.setTarget(faker.bool().bool());
            WorkPosition position = positionRepository.findAll().get(rand.nextInt(positionRepository.findAll().size()));
            employee.setPosition(position);
            employeeList.add(employee);
        }

        employeeRepository.saveAll(employeeList);
    }

    public void getRandomProjects() {
        List<Project> projectList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Project project = new Project();
            project.setName(faker.funnyName().name());
            project.setDeadLine(createRandomEndWorkDate());
            List<Priority> all = priorityRepository.findAll();
            if(!all.isEmpty()){
            Priority priority = all.get(rand.nextInt(priorityRepository.findAll().size()));
            project.setPriority(priority);}
            List<Status> statusRepositoryAll = statusRepository.findAll();
            if(!statusRepositoryAll.isEmpty()){
            Status status = statusRepositoryAll.get(rand.nextInt(statusRepository.findAll().size()));
            project.setStatus(status);}
            projectList.add(project);
        }
        projectRepository.saveAll(projectList);
    }

    public void getRandomAdress() {
        List<Address> adressList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Address address = new Address();
            address.setCity(faker.address().city());
            address.setHouseNumber(faker.address().buildingNumber());
            address.setStreet(faker.address().streetName());
            address.setPostCode(faker.address().zipCode());
            adressList.add(address);
        }
        adressRepository.saveAll(adressList);
    }

    public void getRandomTask() {
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Task task = new Task();
            task.setName(faker.name().title());
            task.setDescription(faker.lorem().sentence());
            task.setEstimateTime(faker.number().numberBetween(1, 20));
            Status status = statusRepository.findAll().get(rand.nextInt(statusRepository.findAll().size()));
            task.setStatus(status);
            task.setEmployee(employeeRepository.findEmployeeByID(rand.nextInt(employeeRepository.findAll().size() - 1)));
            taskList.add(task);
        }
        taskRepository.saveAll(taskList);
    }

    public void addTaskToProject() {
        List<Task> tasks = taskRepository.findAll();
        List<Project> projects = projectRepository.findAll();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            Project project = projects.get(rand.nextInt(projects.size()));
            Set<Task> tasks1 = project.getTasks();
            tasks1.add(task);
            project.setTasks(tasks1);
            task.setProject(project);
            taskRepository.save(task);
            projectRepository.save(project);
        }

    }

    public void addAdressToEmployee() {
        List<Address> addresses = adressRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();
        int j = 0;
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            Address address = addresses.get(j);
            employee.setAddress(address);
            address.setEmployee(employee);
            j++;
            employeeRepository.save(employee);
            adressRepository.save(address);
        }

    }

    public void addEmployeeToProject() {
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            projectRepository.findAll().size();
            employeeRepository.findAll().size();
            Set<Employee> employees = new HashSet<>();
            Set<Project> projects = new HashSet<>();
            int projectId = task.getProject().getId();
            Project project = projectRepository.findById(projectId).orElse(null);
            projects.add(project);
            Employee employee = task.getEmployee();
            if (employee == null) {
                continue;
            }
            employees.add(employee);
            project.setEmployees(employees);
            employee.setProjects(projects);

            employeeRepository.saveAll(employees);
            projectRepository.saveAll(projects);
        }


    }

    public void addEmployeeToProject2() {
        List<EmployeeView> personAndTaskId = taskRepository.findPersonAndTaskId();

        for (EmployeeView element : personAndTaskId) {
            Set<Employee> employees = new HashSet<>();
            Set<Project> projects = new HashSet<>();

            Integer idEmployee = element.getEmployeeId();
            Integer idProject = element.getProjectId();


            Project project = projectRepository.findProjectById(idProject);
            projects.add(project);

            Employee employee = employeeRepository.findEmployeeByID(idEmployee);
            if (employee == null) {
                continue;
            }

            employees.add(employee);
            project.setEmployees(employees);
            employee.setProjects(projects);

            employeeRepository.saveAll(employees);
            projectRepository.saveAll(projects);
        }

    }


}
