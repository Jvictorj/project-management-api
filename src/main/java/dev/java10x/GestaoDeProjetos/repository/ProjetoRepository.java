package dev.java10x.GestaoDeProjetos.repository;

import dev.java10x.GestaoDeProjetos.model.ProjetosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository  extends JpaRepository<ProjetosModel, Long> {
}
