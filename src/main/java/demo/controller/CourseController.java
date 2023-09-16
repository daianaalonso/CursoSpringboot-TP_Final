package demo.controller;

import demo.dto.CourseDTO;
import demo.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseDTO save(@RequestBody CourseDTO courseDTO) {
        return courseService.saveCourse(courseDTO);
    }

    @GetMapping
    public List<CourseDTO> findAll() {
        return courseService.findAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO find(@PathVariable Long id) {
        return courseService.findCourse(id);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        return courseService.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
