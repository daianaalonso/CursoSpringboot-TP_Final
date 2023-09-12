package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByDniGreaterThanAndLastname(int dni, String lastname);

    Page<Student> findByOrderByDniAsc(Pageable pageable);
}
