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

    public VotoId() {
    }

    public VotoId(Long associado_id, Long pauta_id) {
        this.associado_id = associado_id;
        this.pauta_id = pauta_id;
    }

    public Long getAssociado_id() {
        return associado_id;
    }

    public void setAssociado_id(Long associado_id) {
        this.associado_id = associado_id;
    }

    public Long getPauta_id() {
        return pauta_id;
    }

    public void setPauta_id(Long pauta_id) {
        this.pauta_id = pauta_id;
    }

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
