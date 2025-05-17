package com.tec.desafio_sicredi.dto;

import jakarta.validation.constraints.NotBlank;

public class PautaDTO {

    private Long id;
    @NotBlank(message = "o campo de descrição não pode estar vazio")
    private String descricao;
    private Boolean fechada;

    public PautaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
