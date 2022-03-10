package com.company.demo.Services;

import com.company.demo.DTO.EmployeeDTO;
import com.company.demo.DTO.EmployeeMapper;
import com.company.demo.Entity.*;
import com.company.demo.Repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;
    private ProjectRepository projectRepository;
    private StatusRepository statusRepository;
    private PriorityRepository priorityRepository;
    private EmployeeMapper employeeMapper;
    private TaskRepository taskRepository;
    private AdressRepository adressRepository;


    public EmployeeService(EmployeeRepository employeeRepository, PositionRepository positionRepository, ProjectRepository projectRepository, StatusRepository statusRepository, PriorityRepository priorityRepository, EmployeeMapper employeeMapper, TaskRepository taskRepository, AdressRepository adressRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.projectRepository = projectRepository;
        this.statusRepository = statusRepository;
        this.priorityRepository = priorityRepository;
        this.employeeMapper = employeeMapper;
        this.taskRepository = taskRepository;
        this.adressRepository = adressRepository;
    }

    public void create() {
        Employee employee= new Employee();
        employee.setName("Kate");
        employee.setLastName("Jordan");
        employee.setBirthDate(LocalDate.of(1999,02,07));
        employee.setSalary(15000);
        employee.setStartWorkDate(LocalDate.of(2020,01,02));
        employee.setTarget(true);
        employee.setEndWorkDate(LocalDate.of(2030,01,01));
         employeeRepository.save(employee);

    }

    public void fireByID(Integer id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        Set<Task> tasks = employee.getTasks();
        for (Task task : tasks) {
            task.setEmployee(null);
            taskRepository.save(task);
        }

        employeeRepository.deleteById(id);
        employeeRepository.flush();

    }

    public double sumOfSalary(Employee employee) {
        double sumOfSalary = 0;
        if (employee.isTarget() == true) {
            sumOfSalary = employee.getSalary() + employee.getBonus();
        } else sumOfSalary = employee.getSalary();
        return sumOfSalary;
    }

    public List<Employee> getList() {
        List<Employee> list = employeeRepository.findAll();
        return list;
    }

    public double sumOfSalaryStream(boolean withBonus) {
        double sum = 0;

        if (withBonus == true) {
            sum = getList().stream()
                    .map(c -> sumOfSalary(c))
                    .reduce(0.0, (c, b) -> c + b);
        } else {
            sum = getList().stream()
                    .collect((Collectors.summingDouble(Employee::getSalary)));
        }
        return sum;
    }

    public double averageSalaryForWorkers(boolean withBonus) {
        double averageWorker = 0;
        if (withBonus == false) {
            averageWorker = employeeRepository.getEmployeeWithWorkerPosition()
                    .stream()
                    .mapToDouble(Employee::getSalary)
                    .average().orElseThrow(IllegalAccessError::new);
        } else {
            averageWorker = employeeRepository.getEmployeeWithWorkerPosition()
                    .stream()
                    .mapToDouble(p -> sumOfSalary(p))
                    .average()
                    .orElseThrow(IllegalAccessError::new);
        }
        return averageWorker;

    }

    public double averageSalaryForManagers(boolean withBonus) {
        double averageManager = 0;
        if (withBonus == false) {
            averageManager = employeeRepository.getEmployeeWithManagerPosition()
                    .stream()
                    .mapToDouble(Employee::getSalary)
                    .average()
                    .orElseThrow(IllegalAccessError::new);
        } else {
            averageManager = employeeRepository.getEmployeeWithManagerPosition()
                    .stream()
                    .mapToDouble(p -> sumOfSalary(p))
                    .average()
                    .orElseThrow(IllegalAccessError::new);
        }
        return averageManager;
    }

    public double averageDirectorWithoutBonus() {
     return employeeRepository.getEmployeeWithDirectorPosition().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(IllegalAccessError::new);

    }

    public OptionalDouble averageDirectorWithBonus() {
        return employeeRepository.getEmployeeWithDirectorPosition().stream()
                .mapToDouble(p -> sumOfSalary(p))
                .average();
    }

    public String averageSalaryForPositionStream(boolean withBonus) {

        return "Worker avg salary: " + averageSalaryForWorkers(withBonus) + " Manager avg salary: " + averageSalaryForManagers(withBonus) + ". Director avg salary: " + averageDirectorWithoutBonus();
    }

    public double sumOfSalaryWorker(boolean withBonus) {
        double sumaWorker = 0;
        if (withBonus == false) {
            sumaWorker = employeeRepository.getEmployeeWithWorkerPosition()
                    .stream()
                    .mapToDouble(Employee::getSalary).sum();
        } else {
            sumaWorker = employeeRepository.getEmployeeWithWorkerPosition()
                    .stream()
                    .mapToDouble(p -> sumOfSalary(p))
                    .reduce(0.0, Double::sum);
        }
        return sumaWorker;
    }

    public double sumOfSalaryManager(boolean withBonus) {
        double sumaManager = 0;

        if (withBonus == false) {
            sumaManager = employeeRepository.getEmployeeWithManagerPosition()
                    .stream()
                    .mapToDouble(Employee::getSalary).sum();
        } else {

            sumaManager = employeeRepository.getEmployeeWithManagerPosition()
                    .stream()
                    .mapToDouble(p -> sumOfSalary(p))
                    .reduce(0.0, Double::sum);
        }
        return sumaManager;
    }

    public double sumOfSalaryDirector(boolean withBonus) {
        double sumaDirector = 0;
        if (withBonus == false) {
            sumaDirector = employeeRepository.getEmployeeWithDirectorPosition()
                    .stream()
                    .mapToDouble(Employee::getSalary).sum();
        } else {
            sumaDirector = employeeRepository.getEmployeeWithDirectorPosition()
                    .stream()
                    .mapToDouble(p -> sumOfSalary(p))
                    .reduce(0.0, Double::sum);
        }
        return sumaDirector;
    }

    public String sumSalaryOfPositionSTREAM(boolean withBonus) {
        return "Sum of WORKER salary stream is: " + sumOfSalaryWorker(withBonus) + ". Sum of DIRECTOR salary stream is: " + sumOfSalaryManager(withBonus) + ". Sum of MANAGER salary stream is: " + sumOfSalaryDirector(withBonus);

    }


    public double avarangeSalaryOlderThan50Stream(boolean withBonus) {
        double averange = 0;

        if (withBonus == false) {
            averange = getList().stream()
                    .filter(p -> p.getAge() > 50)
                    .mapToDouble(Employee::getSalary)
                    .average()
                    .orElseThrow(IllegalAccessError::new);

        } else {
            averange = getList().stream()
                    .filter(p -> p.getAge() > 50)
                    .mapToDouble(p -> sumOfSalary(p))
                    .average()
                    .orElseThrow(NoSuchFieldError::new);
        }
        return averange;
    }

    public List<Employee> getEmployeeOlderThan50(){
        return employeeRepository.getEmployeeOlderThan50();
    }

    public double getSalaryById(int id) {
        Employee employeeByID = employeeRepository.findEmployeeByID(id);
        return employeeByID.getSalary();
    }

    public double averageSalaryStream(boolean withBonus) {
        double averange = 0;
        if (withBonus == true) {
            averange = getList().stream()
                    .mapToDouble(p -> p.getSalary() + p.getBonus())
                    .average()
                    .orElseThrow(IllegalAccessError::new);
        } else {
            averange = getList().stream()
                    .mapToDouble(p -> p.getSalary())
                    .average()
                    .orElseThrow(IllegalAccessError::new);
        }
        return averange;

    }


    public double averageAgeSteam() {
        double averange = 0;
        averange = getList().stream()
                .mapToDouble(p -> p.getAge())
                .average()
                .orElseThrow(IllegalAccessError::new);
        return averange;
    }

    public double averageAgeWorkers() {
        double averageWorker;
        averageWorker = employeeRepository.getEmployeeWithWorkerPosition()
                .stream()
                .mapToDouble(p -> p.getAge())
                .average()
                .orElseThrow(IllegalAccessError::new);
        return averageWorker;
    }

    public double averageAgeManagers() {
        double averageManager;
        averageManager = employeeRepository.getEmployeeWithManagerPosition()
                .stream()
                .mapToDouble(p -> p.getAge())
                .average()
                .orElseThrow(IllegalAccessError::new);
        return averageManager;
    }

    public double averageAgeDirectors() {
        double averageDirector;
        averageDirector = employeeRepository.getEmployeeWithDirectorPosition()
                .stream()
                .mapToDouble(p -> p.getAge())
                .average()
                .orElseThrow(IllegalAccessError::new);
        return averageDirector;
    }

    public String averageAgeOfPositionStream() {
        return "Average age for Workers " + averageAgeWorkers() + ", Managers " + averageAgeManagers() + " and Directors is: " + averageAgeDirectors();
    }

    public void updateName(int id, String name) {
        Employee employee = employeeRepository.findEmployeeByID(id);
        employee.setName(name);
        employeeRepository.save(employee);


    }

    public void updateLastName(int id, String lastName) {
        Employee employee = employeeRepository.findEmployeeByID(id);
        employee.setLastName(lastName);
        employeeRepository.save(employee);

    }

    public void updateSalary(int id, int salary) {
        Employee employee = employeeRepository.findEmployeeByID(id);
        employee.setSalary(salary);
        employeeRepository.save(employee);

    }



    public void assignToSupervisor(int id, int idEmployee2) {
        Employee employee2 = employeeRepository.findEmployeeByID(idEmployee2);
        Employee em = employeeRepository.findEmployeeByID(id);
        if (em.getPosition() == positionRepository.getById(1)) {
            if (employee2.getPosition().getId() == 2 || employee2.getPosition().getId() == 3 || employee2.getPosition().getId() == 4) {
                em.setSupervisor(employee2);
                employeeRepository.save(em);
                return;
            }
        } else if (em.getPosition() == positionRepository.findById(2).get()) {
            if (employee2.getPosition().getId() == 3 || employee2.getPosition().getId() == 4) {
                em.setSupervisor(employee2);
                employeeRepository.save(em);
                return;
            }
        } else if (em.getPosition() == positionRepository.findById(3).get()) {
            if (employee2.getPosition().getId() == 4) {
                em.setSupervisor(employee2);
                employeeRepository.save(em);
                return;
            }
        } else System.out.println("Impossible");
    }

    public List<EmployeeDTO> isSupervisor(int id) {
        Employee employee = employeeRepository.findEmployeeByID(id);
        List<EmployeeDTO> employeeList = employeeRepository.getAllEmployee()
                .stream()
                .filter(c -> c.getSupervisor() == employee)
                .map(c -> employeeMapper.toDTO(c))
                .collect(Collectors.toList());

        return employeeList;
    }

    public void fireEmployeeByEndWorkDate(int id) {
        Employee emp = employeeRepository.findEmployeeByID(id);
        if (emp.getEndWorkDate().isAfter(LocalDate.now())) {
            emp.setSupervisor(null);
            emp.setProjects(null);
            emp.setTasks(null);
            employeeRepository.save(emp);
        }
    }

    public int getSupervisor(int id) {
        Employee emp = employeeRepository.findEmployeeByID(id);
        return emp.getSupervisor().getId();
    }

    public List<Project> getListOfProject(int id) {
        Employee emp = employeeRepository.findEmployeeByID(id);
        List<Project> projectList = projectRepository.getAllProjects().stream()
                .filter(c -> c.getEmployees().equals(emp))
                .collect(Collectors.toList());
        projectList.removeIf(c -> c.getStatus().equals("Done"));
        return projectList;
    }

    public List<EmployeeDTO> getEmp() {
        return employeeRepository.getAllEmployee()
                .stream().map(c -> employeeMapper.toDTO(c))
                .collect(Collectors.toList());
    }


    public EmployeeDTO get(int id) {
        return employeeMapper.toDTO(employeeRepository.getById(id));
    }

    public EmployeeDTO addEmployeeWithAddress(String name, String lastName, int positionId, LocalDate birthDate,
                                              double salary, LocalDate startWorkDate, boolean target, String city, String street, String houseNumber, String
                                                      postCode, LocalDate endWorkDate) {
        Address address = new Address(city, street, houseNumber, postCode);
        WorkPosition workPosition = this.positionRepository.findById(positionId).orElse(null);
        Employee employee = new Employee(name, lastName, workPosition, birthDate, salary, startWorkDate, target, address, endWorkDate);

        address.setEmployee(employee);
        EmployeeDTO employeeDTO = employeeMapper.toDTO(employee);
        employeeRepository.save(employee);

        return employeeDTO;
    }

    public void updateAddressToEmployee(int employeeId, Address address) {
        Employee employee = employeeRepository.findEmployeeByID(employeeId);
        employee.setAddress(address);
        address.setEmployee(employee);
        adressRepository.save(address);
        employeeRepository.save(employee);
    }

    public void deleteAddressFromEmployee(int employeeId) {
        Employee employee = employeeRepository.findEmployeeByID(employeeId);
        Address address = employee.getAddress();
        employee.setAddress(null);
        employeeRepository.save(employee);
        adressRepository.delete(address);
        adressRepository.flush();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addChanges(int employeeID, double newSalary) {
        Employee employee = employeeRepository.findEmployeeByID(employeeID);
        employee.setSalary(newSalary);

        employeeRepository.save(employee);
        newFunction(employee);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void newFunction(Employee employee) {
        employeeRepository.deleteById(employee.getId());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void editAdressAndSalary(int empId, String city, double salary) {
        Employee employee = employeeRepository.findEmployeeByID(empId);
        employee.setSalary(salary);
        if (!city.equals(employee.getAddress().getCity())) {
            employee.getAddress().setCity(city);
        }
    }
    public List<Employee> findEmployeeWithProject(int id){
        return employeeRepository.findEmployeeFromProject(id);
    }


}
