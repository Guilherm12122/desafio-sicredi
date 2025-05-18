package com.tec.desafio_sicredi.dto;

public class AssociadoDTO {

    private Long id;
    private String nome;

    public AssociadoDTO() {
    }

    public AssociadoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
