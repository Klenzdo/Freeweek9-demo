package com.freedom.demo_spring_hibernate.payload.request;


import com.freedom.demo_spring_hibernate.entity.enums.Absent;
import com.freedom.demo_spring_hibernate.entity.enums.Present;
import com.freedom.demo_spring_hibernate.entity.enums.Reasons;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceRequest {


    private Present present;

    private Absent absent;

    private Reasons reasons;


}
