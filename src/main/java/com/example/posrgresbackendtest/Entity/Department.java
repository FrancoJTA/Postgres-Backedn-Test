package com.example.posrgresbackendtest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data @NoArgsConstructor @AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_generator")
    @SequenceGenerator(
            name = "department_generator",
            sequenceName = "department_sequence_name",
            allocationSize = 1
    )
    private Long id;

    private String DepartmentName;

    private String DepartmentDescription;
}
