package com.tec.desafio_sicredi.repository;

import com.tec.desafio_sicredi.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {
    @Query(value = "SELECT * FROM PAUTA WHERE descricao = :descricao",
            nativeQuery = true)
    Optional<Pauta> getByDescricao(String descricao);
}
