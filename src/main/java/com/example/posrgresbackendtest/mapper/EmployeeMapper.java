package com.example.posrgresbackendtest.mapper;

import com.example.posrgresbackendtest.Entity.Employee;
import com.example.posrgresbackendtest.dto.EmployeeDto;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee emp) {
        return new EmployeeDto(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail(),
                emp.getDepartment().getId()
        );
    }

    public static Employee mapToEmployee(EmployeeDto dto) {
        Employee emp = new Employee();
        emp.setId(dto.getId());
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setEmail(dto.getEmail());
        return emp;
    }

}
