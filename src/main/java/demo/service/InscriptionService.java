package demo.service;

import demo.domain.Course;
import demo.domain.Inscription;
import demo.domain.State;
import demo.domain.Student;
import demo.dto.InscriptionDTO;
import demo.repository.CourseRepository;
import demo.repository.InscriptionRepository;
import demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InscriptionService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final InscriptionRepository inscriptionRepository;

    public InscriptionDTO saveInscription(InscriptionDTO inscriptionDTO) {
        Student student = studentRepository
                .findById(inscriptionDTO.getStudent())
                .orElseThrow(() -> new RuntimeException("El estudiante no existe."));

        if (!student.isAdult())
            throw new RuntimeException("El estudiante es menor de edad.");

        Course course = courseRepository
                .findById(inscriptionDTO.getCourse())
                .orElseThrow(() -> new RuntimeException("El curso no existe."));

        inscriptionRepository.save(new Inscription(
                null,
                inscriptionDTO.getRegistrationDate(),
                State.valueOf(inscriptionDTO.getState()),
                course,
                student));
        return inscriptionDTO;
    }

    public List<InscriptionDTO> findAllInscriptions() {
        return inscriptionRepository.findAll()
                .stream()
                .map(i -> new InscriptionDTO(
                        i.getRegistrationDate(),
                        i.getState().toString(),
                        i.getCourse().getId(),
                        i.getStudent().getId()))
                .collect(Collectors.toList());
    }

    public InscriptionDTO findInscription(Long id) {
        Inscription inscription = inscriptionRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("La inscripción no existe."));
        return new InscriptionDTO(
                inscription.getRegistrationDate(),
                inscription.getState().toString(),
                inscription.getCourse().getId(),
                inscription.getStudent().getId()
        );
    }

    public InscriptionDTO updateInscription(Long id, InscriptionDTO inscriptionDTO) {
        Student student = studentRepository
                .findById(inscriptionDTO.getStudent())
                .orElseThrow(() -> new RuntimeException("El estudiante no existe."));

        if (!student.isAdult())
            throw new RuntimeException("El estudiante es menor de edad.");

        Course course = courseRepository
                .findById(inscriptionDTO.getCourse())
                .orElseThrow(() -> new RuntimeException("El curso no existe."));

        inscriptionRepository.save(new Inscription(
                id,
                inscriptionDTO.getRegistrationDate(),
                State.valueOf(inscriptionDTO.getState()),
                course,
                student
        ));
        return inscriptionDTO;
    }

    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }
}
