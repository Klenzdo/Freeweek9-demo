package com.freedom.demo_spring_hibernate.payload.request;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {


    private String firstName;

    private String lastName;

    private String email;

    private String password;

//    public Object getEmail() {
//        return null;
//    }
}
