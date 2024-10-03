package com.example.posrgresbackendtest.service;

import com.example.posrgresbackendtest.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(Long EmployeeId,EmployeeDto employeeDto);
    void deleteEmployee(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long id);
}
