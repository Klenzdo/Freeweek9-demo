package com.freedom.demo_spring_hibernate.service;

import com.freedom.demo_spring_hibernate.entity.Employee;
import com.freedom.demo_spring_hibernate.payload.request.EmployeeRequest;
import com.freedom.demo_spring_hibernate.payload.response.ApiResponse;
import com.freedom.demo_spring_hibernate.payload.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    ResponseEntity<ApiResponse<EmployeeResponse>> registerEmployee(EmployeeRequest request);

    ResponseEntity<ApiResponse<String>> markAttendance(Long id);

//    Employee register(EmployeeRequest employeeRequest);
}
