package com.example.posrgresbackendtest.service.serviceimpl;

import com.example.posrgresbackendtest.Entity.Department;
import com.example.posrgresbackendtest.dto.DepartmentDto;
import com.example.posrgresbackendtest.exception.ResourceNotFoundException;
import com.example.posrgresbackendtest.mapper.DepartmentMapper;
import com.example.posrgresbackendtest.repository.DepartmentRepository;
import com.example.posrgresbackendtest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment= departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(()-> new ResourceNotFoundException("Department no encontrado"));
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentdescription());
        Department saveDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(()-> new ResourceNotFoundException("Department no encontrado"));
        departmentRepository.deleteById(departmentId);
    }


    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream().map(DepartmentMapper::mapToDepartmentDto).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department no encontrado"));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

}
