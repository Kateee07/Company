package com.company.demo.DTO;

import com.example.demo.Entity.Employee;

public interface Mapper<E, D> {
    E toEntity(EmployeeDTO employeeDTO);
    D toDTO(Employee employee);
}
