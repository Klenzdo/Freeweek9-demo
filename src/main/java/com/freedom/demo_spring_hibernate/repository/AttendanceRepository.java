package com.freedom.demo_spring_hibernate.repository;

import com.freedom.demo_spring_hibernate.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
