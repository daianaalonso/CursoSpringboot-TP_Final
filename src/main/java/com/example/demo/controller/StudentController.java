package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentDTO save(@RequestBody StudentDTO studentDTO) {
        return studentService.saveStudent(studentDTO);
    }

    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO find(@PathVariable Long id) {
        return studentService.findStudent(id);
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(id, studentDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
