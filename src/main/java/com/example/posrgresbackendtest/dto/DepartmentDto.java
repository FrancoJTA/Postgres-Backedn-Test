package com.example.posrgresbackendtest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class DepartmentDto {
    private Long id;
    private String DepartmentName;
    private String Departmentdescription;
}
