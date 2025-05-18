package com.tec.desafio_sicredi.dto.voto;

public class VotoDTO {

    private Boolean a_favor;

    public VotoDTO() {
    }

    public VotoDTO(Boolean a_favor) {
        this.a_favor = a_favor;
    }

    public Boolean getA_favor() {
        return a_favor;
    }

    public void setA_favor(Boolean a_favor) {
        this.a_favor = a_favor;
    }
}
