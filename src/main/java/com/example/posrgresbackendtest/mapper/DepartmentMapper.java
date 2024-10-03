package com.example.posrgresbackendtest.mapper;

import com.example.posrgresbackendtest.Entity.Department;
import com.example.posrgresbackendtest.dto.DepartmentDto;

public class DepartmentMapper {
    //CONVERTIR LA ENTIDAD JPA DEPARTMENT EN UN DTO
    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentdescription()
        );
    }
}