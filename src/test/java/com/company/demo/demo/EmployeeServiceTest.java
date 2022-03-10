package com.company.demo.demo;

import com.example.demo.Entity.Employee;
import com.example.demo.Entity.Task;
import com.example.demo.Repositories.*;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    com.example.demo.Services.EmployeeService employeeService;
    @Mock
    private com.example.demo.Repositories.EmployeeRepository employeeRepository;
    @Mock
    private com.example.demo.Entity.WorkPosition position;
    @Mock
    private com.example.demo.Repositories.ProjectRepository projectRepository;
    @Mock
    private com.example.demo.Repositories.StatusRepository statusRepository;
    @Mock
    private com.example.demo.Repositories.PriorityRepository priorityRepository;
    @Mock
    private com.example.demo.DTO.EmployeeMapper employeeMapper;
    @Mock
    private com.example.demo.Repositories.TaskRepository taskRepository;
    @Mock
    private com.example.demo.Repositories.AdressRepository adressRepository;
    @Mock
    private com.example.demo.Repositories.PositionRepository positionRepository;
    @Mock
    private com.example.demo.Entity.WorkPosition workPosition;


    public List<Employee> preperMock() {
        List<Employee> empList = new ArrayList<>();
        com.example.demo.Entity.WorkPosition workPosition = new com.example.demo.Entity.WorkPosition();
        workPosition.setId(1);
        workPosition.setPosition("Worker");

        com.example.demo.Entity.WorkPosition workPosition2 = new com.example.demo.Entity.WorkPosition();
        workPosition2.setId(2);
        workPosition2.setPosition("Manager");

        com.example.demo.Entity.WorkPosition workPosition3 = new com.example.demo.Entity.WorkPosition();
        workPosition3.setId(3);
        workPosition3.setPosition("Director");

        positionRepository.save(workPosition);
        positionRepository.save(workPosition2);
        positionRepository.save(workPosition3);

        com.example.demo.Entity.Employee employee = new com.example.demo.Entity.Employee();
        employee.setName("Kate");
        employee.setLastName("Jordan");
        employee.setBirthDate(LocalDate.of(1993, 02, 07));
        employee.setSalary(7500);
        employee.setEndWorkDate(LocalDate.of(2025, 01, 01));
        employee.setTarget(true);
        employee.setPosition(workPosition);

        com.example.demo.Entity.Employee employee2 = new com.example.demo.Entity.Employee();
        employee2.setName("Nancy");
        employee2.setLastName("Fluff");
        employee2.setBirthDate(LocalDate.of(1954, 1, 17));
        employee2.setSalary(5000);
        employee2.setEndWorkDate(LocalDate.of(1960, 8, 1));
        employee2.setTarget(true);
        employee2.setPosition(workPosition2);

        com.example.demo.Entity.Employee employee3 = new com.example.demo.Entity.Employee();
        employee3.setName("Megan");
        employee3.setLastName("Fox");
        employee3.setBirthDate(LocalDate.of(2001, 4, 27));
        employee3.setSalary(6000);
        employee3.setEndWorkDate(LocalDate.of(2028, 9, 2));
        employee3.setTarget(true);
        employee3.setPosition(workPosition);

        com.example.demo.Entity.Employee employee4 = new com.example.demo.Entity.Employee();
        employee4.setName("Cris");
        employee4.setLastName("Junior");
        employee4.setBirthDate(LocalDate.of(1985, 4, 27));
        employee4.setSalary(8000);
        employee4.setEndWorkDate(LocalDate.of(2030, 9, 2));
        employee4.setTarget(true);
        employee4.setPosition(workPosition2);

        com.example.demo.Entity.Employee employee5 = new com.example.demo.Entity.Employee();
        employee5.setId(4);
        employee5.setName("Dustin");
        employee5.setLastName("Greg");
        employee5.setBirthDate(LocalDate.of(1990, 4, 27));
        employee5.setSalary(15000);
        employee5.setEndWorkDate(LocalDate.of(2040, 9, 2));
        employee5.setTarget(true);
        employee5.setPosition(workPosition3);

        empList.add(employee);
        empList.add(employee2);
        empList.add(employee3);
        empList.add(employee4);
        empList.add(employee5);

        return empList;
    }

    public List<Employee> preperMockForWorkers() {
        com.example.demo.Entity.WorkPosition workPosition = new com.example.demo.Entity.WorkPosition();
        workPosition.setId(1);
        workPosition.setPosition("Worker");

        com.example.demo.Entity.Employee employee = new com.example.demo.Entity.Employee();
        employee.setName("Megan");
        employee.setLastName("Fox");
        employee.setBirthDate(LocalDate.of(2001, 4, 27));
        employee.setSalary(5000);
        employee.setEndWorkDate(LocalDate.of(2028, 9, 2));
        employee.setTarget(true);
        employee.setPosition(workPosition);

        com.example.demo.Entity.Employee employee2 = new com.example.demo.Entity.Employee();
        employee2.setName("Cris");
        employee2.setLastName("Junior");
        employee2.setBirthDate(LocalDate.of(1985, 4, 27));
        employee2.setSalary(4000);
        employee2.setEndWorkDate(LocalDate.of(2030, 9, 2));
        employee2.setTarget(true);
        employee2.setPosition(workPosition);

        List<Employee> workerEmployee = new ArrayList<>();
        workerEmployee.add(employee);
        workerEmployee.add(employee2);

        return workerEmployee;
    }

    public List<Employee> preperMockForManagers() {
        com.example.demo.Entity.WorkPosition workPosition2 = new com.example.demo.Entity.WorkPosition();
        workPosition2.setId(2);
        workPosition2.setPosition("Manager");

        com.example.demo.Entity.Employee employee3 = new com.example.demo.Entity.Employee();
        employee3.setName("Megan");
        employee3.setLastName("Fox");
        employee3.setBirthDate(LocalDate.of(2001, 4, 27));
        employee3.setSalary(6000);
        employee3.setEndWorkDate(LocalDate.of(2028, 9, 2));
        employee3.setTarget(true);
        employee3.setPosition(workPosition2);

        com.example.demo.Entity.Employee employee4 = new com.example.demo.Entity.Employee();
        employee4.setName("Cris");
        employee4.setLastName("Junior");
        employee4.setBirthDate(LocalDate.of(1985, 4, 27));
        employee4.setSalary(8000);
        employee4.setEndWorkDate(LocalDate.of(2030, 9, 2));
        employee4.setTarget(true);
        employee4.setPosition(workPosition2);
        List<Employee> managerEmployee = new ArrayList<>();
        managerEmployee.add(employee3);
        managerEmployee.add(employee4);

        return managerEmployee;
    }

    public List<Employee> preperMockForDirectors() {
        com.example.demo.Entity.WorkPosition workPosition3 = new com.example.demo.Entity.WorkPosition();
        workPosition3.setId(3);
        workPosition3.setPosition("Director");

        com.example.demo.Entity.Employee employee5 = new com.example.demo.Entity.Employee();
        employee5.setId(4);
        employee5.setName("Dustin");
        employee5.setLastName("Greg");
        employee5.setBirthDate(LocalDate.of(1990, 4, 27));
        employee5.setSalary(15000);
        employee5.setEndWorkDate(LocalDate.of(2040, 9, 2));
        employee5.setTarget(true);
        employee5.setPosition(workPosition3);

        List<Employee> directorList = new ArrayList<>();
        directorList.add(employee5);

        return directorList;
    }

    @Test
    public void sumOFSalaryTestWhenTargetIsFalse() {
        com.example.demo.Entity.Employee employee = new com.example.demo.Entity.Employee();
        employee.setName("Kate");
        employee.setLastName("Jordan");
        employee.setBirthDate(LocalDate.of(1993, 02, 07));
        employee.setSalary(7500);
        employee.setEndWorkDate(LocalDate.of(2025, 01, 01));
        employee.setTarget(false);
        employee.setPosition(workPosition);

        Assert.assertEquals(7500, (int) employeeService.sumOfSalary(employee));

    }

    @Test
    public void sumOFSalaryTestWhenTargetIsTrue() {
        com.example.demo.Entity.WorkPosition workPosition = new com.example.demo.Entity.WorkPosition();
        workPosition.setId(1);
        workPosition.setPosition("Worker");

        com.example.demo.Entity.Employee employee = new com.example.demo.Entity.Employee();
        employee.setName("Kate");
        employee.setLastName("Jordan");
        employee.setBirthDate(LocalDate.of(1993, 02, 07));
        employee.setSalary(7500);
        employee.setEndWorkDate(LocalDate.of(2025, 01, 01));
        employee.setTarget(true);
        employee.setPosition(workPosition);

        double sum = employeeService.sumOfSalary(employee);

        Assert.assertEquals(8250, (int) sum);

    }

    @Test
    public void getEmployeeListTest() {

        List<Employee> employeeList = preperMock();
        when(employeeService.getList()).thenReturn(employeeList);
        Assert.assertThat(employeeService.getList(), Matchers.hasSize(5));
    }

    @Test
    public void getSumOfSalaryWithBonusTest() {
        List<Employee> employeeList = preperMock();
        when(employeeService.getList()).thenReturn(employeeList);
        Assert.assertEquals(57050, (int) employeeService.sumOfSalaryStream(true));
    }

    @Test
    public void getSumOfSalaryWithoutBonusTest() {
        List<Employee> employeeList = preperMock();
        when(employeeService.getList()).thenReturn(employeeList);
        Assert.assertEquals(41500, (int) employeeService.sumOfSalaryStream(false));
    }

    @Test
    public void averageSalaryForWorkersWithoutBonusTest() {
        when(employeeRepository.getEmployeeWithWorkerPosition()).thenReturn(preperMockForWorkers());
        Assert.assertEquals(4500, (employeeService.averageSalaryForWorkers(false)), 0.001);

    }

    @Test
    public void averageSalaryForWorkersWithBonusTest() {
        when(employeeRepository.getEmployeeWithWorkerPosition()).thenReturn(preperMockForWorkers());
        Assert.assertEquals(4950, (int) employeeService.averageSalaryForWorkers(true));
    }

    @Test
    public void averageSalaryForMenagersWithoutBonusTest() {

        when(employeeRepository.getEmployeeWithManagerPosition()).thenReturn(preperMockForManagers());
        Assert.assertEquals(7000, (int) employeeService.averageSalaryForManagers(false));

    }

    @Test
    public void averageSalaryForManagersWithBonusTest() {
        when(employeeRepository.getEmployeeWithManagerPosition()).thenReturn(preperMockForManagers());
        Assert.assertEquals(9800, (int) employeeService.averageSalaryForManagers(true));

    }

    @Test
    public void averageSalaryForDirectorsWithoutBonusTest() {
        when(employeeRepository.getEmployeeWithDirectorPosition()).thenReturn(preperMockForDirectors());
        Assert.assertEquals(15000, (int) employeeService.averageDirectorWithoutBonus());

    }

    @Test
    public void averageSalaryForDirectorsWithBonusTest() {
        when(employeeRepository.getEmployeeWithDirectorPosition()).thenReturn(preperMockForDirectors());
        Assert.assertEquals(OptionalDouble.of(24000), employeeService.averageDirectorWithBonus());
    }

    @Test
    public void averageSalaryOlderThan50WithBonus() {
        List<Employee> employeeList = preperMock();
        when(employeeService.getList()).thenReturn(employeeList);
        Assert.assertEquals(7000, (int) employeeService.avarangeSalaryOlderThan50Stream(true));
    }

    @Test
    public void averageSalaryOlderThan50WithoutBonus() {
        List<Employee> employeeList = preperMock();
        when(employeeService.getList()).thenReturn(employeeList);
        Assert.assertEquals(5000, (int) employeeService.avarangeSalaryOlderThan50Stream(false));
    }

    @Test
    public void sumOfSalaryWorkerTest() {
        when(employeeRepository.getEmployeeWithWorkerPosition()).thenReturn(preperMockForWorkers());
        Assert.assertEquals(9000, (int) employeeService.sumOfSalaryWorker(false));
    }

    @Test
    public void sumOfSalaryWorkerWithBonusTest() {
        when(employeeRepository.getEmployeeWithWorkerPosition()).thenReturn(preperMockForWorkers());
        Assert.assertEquals(9900, (int) employeeService.sumOfSalaryWorker(true));
    }

    @Test
    public void sumOfSalaryManagerTest() {
        when(employeeRepository.getEmployeeWithManagerPosition()).thenReturn(preperMockForManagers());
        Assert.assertEquals(14000, (int) employeeService.sumOfSalaryManager(false));
    }

    @Test
    public void sumOfSalaryManagerWithBonusTest() {
        when(employeeRepository.getEmployeeWithManagerPosition()).thenReturn(preperMockForManagers());
        Assert.assertEquals(19600, (int) employeeService.sumOfSalaryManager(true));
    }

    @Test
    public void sumOfSalaryDirectorTest() {
        when(employeeRepository.getEmployeeWithDirectorPosition()).thenReturn(preperMockForDirectors());
        Assert.assertEquals(15000, (int) employeeService.sumOfSalaryDirector(false));
    }

    @Test
    public void sumOfSalaryDirectorWitBonusTest() {
        when(employeeRepository.getEmployeeWithDirectorPosition()).thenReturn(preperMockForDirectors());
        Assert.assertEquals(24000, (int) employeeService.sumOfSalaryDirector(true));
    }

    @Test
    public void averageSalaryWithBonusTest() {
        List<Employee> employeeList = preperMock();
        when(employeeService.getList()).thenReturn(employeeList);
        Assert.assertEquals(11410, (int) employeeService.averageSalaryStream(true));
    }

    @Test
    public void averageSalaryWithoutBonusTest() {
        List<Employee> employeeList = preperMock();
        when(employeeService.getList()).thenReturn(employeeList);
        Assert.assertEquals(8300, (int) employeeService.averageSalaryStream(false));
    }

    @Test
    public void averageAge() {
        List<Employee> employeeList = preperMock();
        when(employeeService.getList()).thenReturn(employeeList);
        Assert.assertEquals(36.4, employeeService.averageAgeSteam(), 0.001);
    }

    @Test
    public void averageAgeWorkers() {
        when(employeeRepository.getEmployeeWithWorkerPosition()).thenReturn(preperMockForWorkers());
        Assert.assertEquals(28, employeeService.averageAgeWorkers(), 0.001);
    }

    @Test
    public void averageAgeManagers() {
        when(employeeRepository.getEmployeeWithManagerPosition()).thenReturn(preperMockForManagers());
        Assert.assertEquals(28, employeeService.averageAgeManagers(), 0.001);
    }

    @Test
    public void averageAgeDirectors() {
        when(employeeRepository.getEmployeeWithDirectorPosition()).thenReturn(preperMockForDirectors());
        Assert.assertEquals(31, employeeService.averageAgeDirectors(), 0.001);
    }

    @Test
    public void assignToSupervisor() {
        int em = 1;
        int em2 = 2;
        List<Employee> employeeList = preperMock();


        com.example.demo.Entity.Employee employee = employeeList.get(1);
        com.example.demo.Entity.Employee employee1 = employeeList.get(2);

        employee.setSupervisor(employee1);
        when(employeeRepository.findEmployeeByID(em)).thenReturn(employee);

        doCallRealMethod().when(employeeService).assignToSupervisor(any(Integer.class), any(Integer.class));
        employeeService.assignToSupervisor(em, em2);

        verify(employeeService, times(1)).assignToSupervisor(em, em2);
    }

    @Test
    public void fireEmployeeById() {
        List<Employee> employees = new ArrayList<>();
        Set<Task> tasks = new HashSet<>();
        com.example.demo.Entity.Employee employee = new com.example.demo.Entity.Employee();
        employee.setId(1);
        employee.setName("Kate");
        employee.setLastName("Jordan");
        employee.setBirthDate(LocalDate.of(1993, 02, 07));
        employee.setSalary(7500);
        employee.setEndWorkDate(LocalDate.of(2025, 01, 01));
        employees.add(employee);
        employee.setTasks(tasks);

        Mockito.when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));


        employeeService.fireByID(0);
        employees.remove(employee);

        Assert.assertEquals(employee, employeeRepository.findAll());
        //  Assert.assertEquals(employees, employeeRepository.findAll());

    }


}
