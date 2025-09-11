package dev.java10x.GestaoDeProjetos.Projetos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")

public class ProjetosController {

    private ProjetoService projetoService;

    public ProjetosController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarProjeto(ProjetoDTO projeto) {
        ProjetoDTO newProjeto = projetoService.criarProjeto(projeto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Seu Projeto: " + newProjeto.getTitulo() + " foi criado com sucesso");
    }

    @GetMapping ("/listar")
    public ResponseEntity<List<ProjetoDTO>> listarProjetos() {
        List<ProjetoDTO> projetoList = projetoService.listarProjeto();
        return ResponseEntity.ok(projetoList);
    }

    @GetMapping ("/listar/{id}")
    public ResponseEntity<?> listarProjetosPorId(@PathVariable Long id) {
        ProjetoDTO projetoById = projetoService.listarProjetoPorId(id);
        if (projetoById != null) {
            return ResponseEntity.ok(projetoById);
        }   else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Projeto com ID: " + id + " não encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarProjetoPorId(@PathVariable Long id, @RequestBody ProjetoDTO atualizarProjeto) {
        ProjetoDTO projetoUpdateById = projetoService.atualizarProjeto(id, atualizarProjeto);
        if (projetoUpdateById != null) {
            return ResponseEntity.ok(projetoUpdateById);
        }   else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Projeto com ID: " + id + " não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProjetoPorId(@PathVariable Long id) {
        ProjetoDTO projetoDeleteById = projetoService.listarProjetoPorId(id);
        if (projetoDeleteById != null) {
            return ResponseEntity.ok("Projeto de ID: " + id + "Foi deletado com sucesso");
        }   else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Projeto com ID: " + id + " Não encontrado");
        }
    }

}
