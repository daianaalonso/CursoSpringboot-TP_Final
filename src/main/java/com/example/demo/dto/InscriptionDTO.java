package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InscriptionDTO {
    private LocalDate registrationDate;
    private String state;
    private Long course;
    private Long student;
}
