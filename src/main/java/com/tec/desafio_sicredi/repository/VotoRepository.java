package com.tec.desafio_sicredi.repository;
import com.tec.desafio_sicredi.model.voto.Voto;
import com.tec.desafio_sicredi.model.voto.VotoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotoRepository extends JpaRepository<Voto, VotoId> {
    @Query(value = "SELECT * FROM VOTO WHERE pauta_id = :pauta_id",
            nativeQuery = true)
    Optional<List<Voto>> getVotosByIdPauta(Long pauta_id);

    @Query(value = "SELECT * FROM VOTO WHERE pauta_id = :pauta_id AND associado_id = :associado_id",
        nativeQuery = true)
    Optional<Voto> getByAssociadoIdPautaId(Long pauta_id, Long associado_id);
}
