package dev.java10x.GestaoDeProjetos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.GestaoDeProjetos.model.enums.StatusDoProjeto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_projeto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjetosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim_prevista")
    private LocalDate dataFimPrevista;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusDoProjeto status;

    // Um projeto pode ter varios consultores
    @OneToMany(mappedBy = "projetos")
    @JsonIgnore
    private List<ConsultorModel> consultores;

}
