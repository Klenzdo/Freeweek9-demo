package com.freedom.demo_spring_hibernate.payload.response;


import com.freedom.demo_spring_hibernate.entity.enums.Absent;
import com.freedom.demo_spring_hibernate.entity.enums.Present;
import com.freedom.demo_spring_hibernate.entity.enums.Reasons;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceResponse {

    private Present present;

    private Absent absent;

    private Reasons reasons;
}
