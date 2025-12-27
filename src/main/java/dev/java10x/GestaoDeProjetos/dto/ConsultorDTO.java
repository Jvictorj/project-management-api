package dev.java10x.GestaoDeProjetos.dto;

import dev.java10x.GestaoDeProjetos.model.enums.CargoDoConsultor;
import dev.java10x.GestaoDeProjetos.model.ProjetosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultorDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private CargoDoConsultor cargo;
    private String frase;
    private ProjetosModel projetos;

}
