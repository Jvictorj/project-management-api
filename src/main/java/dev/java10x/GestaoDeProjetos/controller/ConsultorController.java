package dev.java10x.GestaoDeProjetos.Consultor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultor")

public class ConsultorController {

    private ConsultorService consultorService;

    public ConsultorController(ConsultorService consultorService) {
        this.consultorService = consultorService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarConsultor (@RequestBody ConsultorDTO consultorDTO) {
        ConsultorDTO newConsultor = consultorService.criarConsultor(consultorDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Seu Usuario de id: " + newConsultor.getNome() + " foi criado com sucesso");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ConsultorDTO>> listarConsultor () {
        List<ConsultorDTO> consultor = consultorService.listarConsultor();
        return ResponseEntity.ok(consultor);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarConsultorPorId (@PathVariable Long id) {
        ConsultorDTO listarConsultor = consultorService.listarConsultorPorId(id);
        if (listarConsultor != null) {
            return ResponseEntity.ok(listarConsultor);
        }   else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Consultor com ID: " + id + " não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarConsultorPorId (@PathVariable Long id, @RequestBody ConsultorDTO atualizarConsultor) {
        ConsultorDTO alterarConsultor = consultorService.atualizarConsultor(id, atualizarConsultor);
        if (alterarConsultor != null) {
            return ResponseEntity.ok(alterarConsultor);
        }   else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Consultor com ID: " + id + " Não encontrado");
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarConsulorPorId (@PathVariable Long id) {
        if (consultorService.listarConsultorPorId(id) != null) {
            consultorService.deletarConsultorPorId(id);
            return ResponseEntity.ok("Consultor de ID: " + id + "Foi deletado com sucesso");
        }   else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Consultor com ID: " + id + " Não encontrado");
        }
    }

}
