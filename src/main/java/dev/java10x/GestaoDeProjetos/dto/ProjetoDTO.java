package dev.java10x.GestaoDeProjetos.Projetos;

import dev.java10x.GestaoDeProjetos.model.ConsultorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFimPrevista;
    private StatusDoProjeto status;
    private List<ConsultorModel> consultores;

}
