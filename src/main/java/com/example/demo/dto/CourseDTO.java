package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CourseDTO {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
