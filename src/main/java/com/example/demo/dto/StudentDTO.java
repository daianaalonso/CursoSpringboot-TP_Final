package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StudentDTO {
    private String firstname;
    private String lastname;
    private String email;
    private int dni;
    private LocalDate birthDate;

}
