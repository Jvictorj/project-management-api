package dev.java10x.GestaoDeProjetos.repository;

import dev.java10x.GestaoDeProjetos.model.ConsultorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultorRepository extends JpaRepository<ConsultorModel, Long> {
}
