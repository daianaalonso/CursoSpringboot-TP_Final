package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //B
    @Query("SELECT s FROM Student s")
    List<Student> findAllStudents();

    //C
    @Query("SELECT s FROM Student s WHERE s.dni > 20000000 AND s.lastname = 'Romero'")
    List<Student> findAllByDniGreaterThan20MAAndLastnameIsRomero();

    //E -> B con consulta derivada
    List<Student> findAll();

    //E -> C con consulta derivada
    List<Student> findByDniGreaterThanAndLastname(int dni, String lastname);

    //I
    Page<Student> findByOrderByDniAsc(Pageable pageable);
}
