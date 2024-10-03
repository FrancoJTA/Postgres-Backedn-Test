package com.example.posrgresbackendtest.service;

import com.example.posrgresbackendtest.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto addDepartment(DepartmentDto departmentDto);
    DepartmentDto updateDepartment(Long departmentId,DepartmentDto departmentDto);
    void deleteDepartment(Long departmentId);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto getDepartmentById(Long id);
}
