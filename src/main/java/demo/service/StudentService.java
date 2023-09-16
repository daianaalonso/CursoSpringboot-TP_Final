package demo.service;

import demo.domain.Student;
import demo.dto.StudentDTO;
import demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = new Student(
                null,
                studentDTO.getFirstname(),
                studentDTO.getLastname(),
                studentDTO.getEmail(),
                studentDTO.getDni(),
                studentDTO.getBirthDate()
        );
        studentRepository.save(student);
        return studentDTO;
    }

    public List<StudentDTO> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(e -> new StudentDTO(
                        e.getFirstname(),
                        e.getLastname(),
                        e.getEmail(),
                        e.getDni(),
                        e.getBirthDate()))
                .collect(Collectors.toList());
    }

    public StudentDTO findStudent(Long id) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("El estudiante no existe."));
        return new StudentDTO(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail(),
                student.getDni(),
                student.getBirthDate()
        );
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student student = new Student(
                id,
                studentDTO.getFirstname(),
                studentDTO.getLastname(),
                studentDTO.getEmail(),
                studentDTO.getDni(),
                studentDTO.getBirthDate()
        );

        studentRepository.save(student);

        return studentDTO;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
