package com.example.posrgresbackendtest.repository;

import com.example.posrgresbackendtest.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
