package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.dto.CourseDTO;
import com.example.demo.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = new Course(
                null,
                courseDTO.getName(),
                courseDTO.getDescription(),
                courseDTO.getStartDate(),
                courseDTO.getEndDate()
        );
        courseRepository.save(course);
        return courseDTO;
    }

    public List<CourseDTO> findAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(c -> new CourseDTO(
                        c.getName(),
                        c.getDescription(),
                        c.getStartDate(),
                        c.getEndDate()))
                .collect(Collectors.toList());
    }

    public CourseDTO findCourse(Long id) {
        Course course = courseRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("El curso no existe."));
        return new CourseDTO(
                course.getName(),
                course.getDescription(),
                course.getStartDate(),
                course.getEndDate()
        );
    }

    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = new Course(
                id,
                courseDTO.getName(),
                courseDTO.getDescription(),
                courseDTO.getStartDate(),
                courseDTO.getEndDate()
        );
        courseRepository.save(course);
        return courseDTO;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
