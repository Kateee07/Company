package com.company.demo.Controllers;

import com.company.demo.DTO.EmployeeDTO;
import com.company.demo.Entity.Address;
import com.company.demo.Entity.Project;
import com.company.demo.Services.EmployeeService;
import com.company.demo.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;


@RestController
@RequestMapping("/company")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping(value = "/addWithAdress", method = RequestMethod.POST)
    public EmployeeDTO addWithAddress(@RequestParam String name, @RequestParam String lastName, @RequestParam int position, @RequestParam LocalDate birthDate,
                                      @RequestParam double salary, @RequestParam LocalDate startWorkDate, @RequestParam boolean target, @RequestParam String city,
                                      @RequestParam String street, @RequestParam String houseNumber, @RequestParam String postCode, @RequestParam LocalDate endWorkDate) {
        return employeeService.addEmployeeWithAddress(name, lastName, position, birthDate, salary, startWorkDate, target, city, street, houseNumber, postCode, endWorkDate);
    }

    @RequestMapping(value = "/supervisor", method = RequestMethod.POST)
    public void asignToSupervisor(@RequestParam int idEmployee, @RequestParam int idEmployee2) {
        employeeService.assignToSupervisor(idEmployee, idEmployee2);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee() {
        employeeService.create();
    }

    @RequestMapping(value = "/updateSalary", method = RequestMethod.PUT)
    public void updateSalary(int id, int salary) {
        employeeService.updateSalary(id, salary);
    }


    @DeleteMapping("/fire")
    @ResponseStatus(HttpStatus.OK)
    public void fireEmployee(Integer id) {
        employeeService.fireByID(id);
    }

    @GetMapping("/endWork")
    public void endWork( int id) {
        employeeService.fireEmployeeByEndWorkDate(id);
    }

    @GetMapping("/getSupervisor/{id}")
    public int getSupervisor(@PathVariable int id) {
        return employeeService.getSupervisor(id);
    }

    @GetMapping("/getListOFProject/{employeeId}")
    public List<Project> getListOfProject(@PathVariable int employeeId) {
        return employeeService.getListOfProject(employeeId);
    }

    @GetMapping("/isSuper/{employeeId}")
    public List<EmployeeDTO> isSupervisor(@PathVariable int employeeId) {
        return employeeService.isSupervisor(employeeId);
    }

    @GetMapping("/get")
    public List<EmployeeDTO> get() {
        List<EmployeeDTO> employee = employeeService.getEmp();
        return employee;
    }

    @GetMapping("/getByID/{id}")
    public EmployeeDTO getByID(@PathVariable int id) {
        return employeeService.get(id);
    }

    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    public void updateAddress( int employeeId, Address address) {
        employeeService.updateAddressToEmployee(employeeId, address);
    }

    @DeleteMapping("deleteAddress")
    public void deleteAddress( int employeeId) {
        employeeService.deleteAddressFromEmployee(employeeId);
    }

    @PutMapping("/addTransactionalChanges")
    public void addChanges( int empId, double salary) {
        employeeService.addChanges(empId, salary);
    }


    @PutMapping("changeAddressAndSalary")
    public void changeAddressAndCity(int empId, String city, double salary) {
        employeeService.editAdressAndSalary(empId, city, salary);
    }

    @GetMapping("/sum")
    @ResponseBody
    public double sumOFSalaryAll() {
        return employeeService.sumOfSalaryStream(true);
    }

    @GetMapping("/averageSalAll")
    @ResponseBody
    public double averageSalaryAll() {
        return employeeService.averageSalaryStream(true);
    }

//    @GetMapping("/avSalPos")
//    @ResponseBody
//    public String averageSalaryOfPosition() {
//        return employeeService.averageSalaryForPositionStream(true);
//    }

    @GetMapping("/avgSaLWorkers")
    @ResponseBody
    public double averageSalaryForWorkers() {
        return employeeService.averageSalaryForWorkers(true);
    }

    @GetMapping("/avgSaLDirectorWithBonus")
    @ResponseBody
    public OptionalDouble averageDirectorWithBonus() {
        return employeeService.averageDirectorWithBonus();
    }

    @GetMapping("/avgSaLDirectorWithoutBonus")
    @ResponseBody
    public double averageDirectorWithoutBonus() {
        return employeeService.averageDirectorWithoutBonus();
    }

    @GetMapping("/sumSalPos")
    @ResponseBody
    public String sumSalaryOfPosition() {
        return employeeService.sumSalaryOfPositionSTREAM(true);
    }

    @GetMapping("/sumSalWorker")
    @ResponseBody
    public double sumOfSalaryWorker() {
        return employeeService.sumOfSalaryWorker(true);
    }

    @GetMapping("/avgSal50")
    public double averangeSalaryOlder50() {
        return employeeService.avarangeSalaryOlderThan50Stream(true);
    }

    @GetMapping("/avSal50Repository")
    public List averangeSalaryOlder50test() {
        return employeeService.getEmployeeOlderThan50();
    }

    @GetMapping("/salary/{id}")
    public double salaryByID(@PathVariable int id) {
        return employeeService.getSalaryById(id);
    }

    @GetMapping("/avgAge")
    @ResponseBody
    public double averageAge() {
        return employeeService.averageAgeSteam();
    }

    @GetMapping("/avgAgePos")
    @ResponseBody
    public String averageAgeOfPosition() {
        return employeeService.averageAgeOfPositionStream();
    }

    @PutMapping("/editName")
    @ResponseBody
    public void editName( int id) {
        employeeService.updateName(id, "Kateee");
    }

    @PutMapping("/editLastName")
    @ResponseBody
    public void editLastName(int id) {
        employeeService.updateLastName(id, "Mykonos");
    }

    @PutMapping("/editSalary")
    @ResponseBody
    public void editSalary(int id) {
        employeeService.updateSalary(id, 7000);
    }

    @GetMapping("findEmployeeByProjectID/{id}")
    public List<Employee> findEmployeeByProjectID(@PathVariable int id) {
        List<Employee> employee = employeeService.findEmployeeWithProject(id);
        return employee;

    }

}

