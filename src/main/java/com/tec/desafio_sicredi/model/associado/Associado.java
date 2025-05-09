package com.tec.desafio_sicredi.model.associado;

import jakarta.persistence.*;

@Entity
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;
}
