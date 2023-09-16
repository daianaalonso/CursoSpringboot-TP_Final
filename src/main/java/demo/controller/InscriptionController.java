package demo.controller;

import demo.dto.InscriptionDTO;
import demo.service.InscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscription")
@AllArgsConstructor
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @PostMapping
    public InscriptionDTO save(@RequestBody InscriptionDTO inscriptionDTO) {
        return inscriptionService.saveInscription(inscriptionDTO);
    }

    @GetMapping
    public List<InscriptionDTO> findAll() {
        return inscriptionService.findAllInscriptions();
    }

    @GetMapping("/{id}")
    public InscriptionDTO find(@PathVariable Long id) {
        return inscriptionService.findInscription(id);
    }

    @PutMapping("/{id}")
    public InscriptionDTO update(@PathVariable Long id, @RequestBody InscriptionDTO inscriptionDTO) {
        return inscriptionService.updateInscription(id, inscriptionDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
    }
}
