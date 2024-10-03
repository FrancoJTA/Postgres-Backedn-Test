package com.example.posrgresbackendtest.repository;

import com.example.posrgresbackendtest.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
