package dev.java10x.GestaoDeProjetos.Consultor;

import dev.java10x.GestaoDeProjetos.Projetos.ProjetosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_consultor")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ConsultorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo")
    private CargoDoConsultor cargo;

    @Column(name = "frase")
    private String frase;

    //Varios consultores podem ter um mesmo projeto
    @ManyToOne
    @JoinColumn(name = "projetos_id") //chave estrangeira
    private ProjetosModel projetos;

}