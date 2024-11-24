package com.freedom.demo_spring_hibernate.controller;


import com.freedom.demo_spring_hibernate.payload.request.EmployeeRequest;
import com.freedom.demo_spring_hibernate.payload.response.ApiResponse;
import com.freedom.demo_spring_hibernate.payload.response.EmployeeResponse;
import com.freedom.demo_spring_hibernate.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping ("register")
    public ResponseEntity<ApiResponse<EmployeeResponse>> registerEmployee(
            @RequestBody EmployeeRequest request){

        return employeeService.registerEmployee(request);
    }
    @PostMapping ("markAttendance/{id}")
    public ResponseEntity<ApiResponse<String>> markAttendance(@PathVariable Long id){

        return employeeService.markAttendance(id);

    }

}



