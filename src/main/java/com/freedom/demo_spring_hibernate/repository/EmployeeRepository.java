package com.freedom.demo_spring_hibernate.repository;

import com.freedom.demo_spring_hibernate.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    boolean existsByEmail(String email);
}
