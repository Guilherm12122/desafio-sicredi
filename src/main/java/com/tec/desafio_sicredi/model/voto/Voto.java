package com.tec.desafio_sicredi.model.voto;

import com.tec.desafio_sicredi.model.pauta.Pauta;
import com.tec.desafio_sicredi.model.associado.Associado;
import jakarta.persistence.*;

@Entity
public class Voto {

    @EmbeddedId
    private VotoId votoId;

    @ManyToOne(optional = false)
    @MapsId("associado_id")
    @JoinColumn(name = "associado_id")
    private Associado associado;

    @ManyToOne(optional = false)
    @MapsId("pauta_id")
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

    @Column(name = "a_favor")
    private Boolean a_favor;

    public VotoId getVotoId() {
        return votoId;
    }

    public void setVotoId(VotoId votoId) {
        this.votoId = votoId;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public Boolean getA_favor() {
        return a_favor;
    }

    public void setA_favor(Boolean a_favor) {
        this.a_favor = a_favor;
    }
}
