package com.tec.desafio_sicredi.model.voto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VotoId implements Serializable {
    @Column(name = "associado_id")
    private Long associado_id;
    @Column(name = "pauta_id")
    private Long pauta_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VotoId)) return false;
        VotoId that = (VotoId) o;
        return Objects.equals(associado_id, that.associado_id) &&
                Objects.equals(pauta_id, that.pauta_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(associado_id, pauta_id);
    }

}
