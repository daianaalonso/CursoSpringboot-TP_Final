package com.example.demo.repository;

import com.example.demo.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    //A
    @Query("SELECT c FROM Course c")
    List<Course> findAllCourses();

    //E -> A con consulta derivada
    List<Course> findAll();

    //F
    @Query("SELECT c FROM Course c WHERE c.startDate > TO_DATE('2020-02-01')")
    List<Course> findCoursesStartingAfterGivenDate();

    //F -> con consulta derivada
    List<Course> findByStartDateIsAfter(LocalDate startDate);
}
