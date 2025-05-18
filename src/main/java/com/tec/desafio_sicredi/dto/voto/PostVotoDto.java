package com.tec.desafio_sicredi.dto.voto;

public class PostVotoDto {

    private Long associado_id;
    private Long pauta_id;
    private Boolean a_favor;

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

    public Boolean getA_favor() {
        return a_favor;
    }

    public void setA_favor(Boolean a_favor) {
        this.a_favor = a_favor;
    }

    @Override
    public String toString() {
        return "PostVotoDto{" +
                "associado_id=" + associado_id +
                ", pauta_id=" + pauta_id +
                ", a_favor=" + a_favor +
                '}';
    }
}
