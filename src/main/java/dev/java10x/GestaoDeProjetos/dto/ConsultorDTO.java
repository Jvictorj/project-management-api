package dev.java10x.GestaoDeProjetos.Consultor;

import dev.java10x.GestaoDeProjetos.Projetos.ProjetosModel;
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
