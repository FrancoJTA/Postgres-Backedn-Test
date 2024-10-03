package com.example.posrgresbackendtest.service.serviceimpl;

import com.example.posrgresbackendtest.Entity.Department;
import com.example.posrgresbackendtest.Entity.Employee;
import com.example.posrgresbackendtest.dto.EmployeeDto;
import com.example.posrgresbackendtest.exception.ResourceNotFoundException;
import com.example.posrgresbackendtest.mapper.EmployeeMapper;
import com.example.posrgresbackendtest.repository.DepartmentRepository;
import com.example.posrgresbackendtest.repository.EmployeeRepository;
import com.example.posrgresbackendtest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        //buscar si el departamento existe
        Department department= departmentRepository.findById(employeeDto.getDepartmentId()).orElseThrow(()->new ResourceNotFoundException("Department not found"));
        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


    @Override
    public EmployeeDto updateEmployee(Long EmployeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(EmployeeId).orElseThrow(()-> new ResourceNotFoundException("Empleado no encontrado"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Department department= departmentRepository.findById(employeeDto.getDepartmentId()).orElseThrow(()->new ResourceNotFoundException("Department not found"));

        employee.setDepartment(department);
        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
            new ResourceNotFoundException("El id del empleado no existe"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
