package com.freedom.demo_spring_hibernate.entity;


import com.freedom.demo_spring_hibernate.entity.enums.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "employee_tbl")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseClass{


    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    @OneToMany (mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Attendance> attendances;


}
