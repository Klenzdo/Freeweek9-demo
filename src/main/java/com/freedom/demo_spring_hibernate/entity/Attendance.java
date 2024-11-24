package com.freedom.demo_spring_hibernate.entity;

import com.freedom.demo_spring_hibernate.entity.enums.Absent;
import com.freedom.demo_spring_hibernate.entity.enums.Present;
import com.freedom.demo_spring_hibernate.entity.enums.Reasons;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attendance_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attendance extends BaseClass{

    @Enumerated(EnumType.STRING)
    private Present present;

    private Absent absent;

    @Enumerated(EnumType.STRING)
    private Reasons reasons;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
