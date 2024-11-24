package com.freedom.demo_spring_hibernate.service.Impl;

import com.freedom.demo_spring_hibernate.entity.Attendance;
import com.freedom.demo_spring_hibernate.entity.Employee;
import com.freedom.demo_spring_hibernate.entity.enums.Present;
import com.freedom.demo_spring_hibernate.entity.enums.Roles;
import com.freedom.demo_spring_hibernate.payload.request.EmployeeRequest;
import com.freedom.demo_spring_hibernate.payload.response.ApiResponse;
import com.freedom.demo_spring_hibernate.payload.response.EmployeeResponse;
import com.freedom.demo_spring_hibernate.repository.AttendanceRepository;
import com.freedom.demo_spring_hibernate.repository.EmployeeRepository;
import com.freedom.demo_spring_hibernate.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final AttendanceRepository attendanceRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AttendanceRepository attendanceRepository) {
        this.employeeRepository = employeeRepository;
        this.attendanceRepository = attendanceRepository;
    }




    @Override
    public ResponseEntity<ApiResponse<EmployeeResponse>> registerEmployee(EmployeeRequest request) {

        // first check if the employee already has an account
        boolean isEmailPresent = employeeRepository.existsByEmail(request.getEmail());

        if (isEmailPresent){
            throw new RuntimeException("Email already exists");
        }


        Employee newEmployee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .roles(Roles.USER)

                .build();

        employeeRepository.save(newEmployee);
        EmployeeResponse response = EmployeeResponse.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())

                .build();



        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Account Created Successfully", response));
    }

    @Override
    public ResponseEntity<ApiResponse<String>> markAttendance(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
        log.info("Employee successfully retrieved with id {}",employee.getId());
        Attendance attendance = Attendance.builder()
                .present(Present.YES)
                .employee(employee)
                .build();

        attendanceRepository.save(attendance);
        return ResponseEntity.ok(new ApiResponse<>("Employee Successfully marked attendance",""));
    }


}
