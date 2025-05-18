package com.tec.desafio_sicredi.repository;

import com.tec.desafio_sicredi.model.associado.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
}
