package com.tec.desafio_sicredi.dto;

import jakarta.validation.constraints.NotBlank;

public class PautaDTO {

    @NotBlank(message = "o campo de descrição não pode estar vazio")
    private String descricao;
    private Boolean fechada;

    public PautaDTO() {
    }

    public Boolean getFechada() {
        return fechada;
    }

    public void setFechada(Boolean fechada) {
        this.fechada = fechada;
    }

    public PautaDTO(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
