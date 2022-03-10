package com.company.demo.DTO;

import com.company.demo.Entity.Employee;
import org.springframework.stereotype.Component;

@Component
public abstract class EmployeeMapper implements com.company.demo.DTO.Mapper<Employee, EmployeeDTO> {
    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        return employee;
    }

    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO(employee);
        return employeeDTO;
    }
}
