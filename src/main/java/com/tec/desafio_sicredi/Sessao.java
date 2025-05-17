package com.tec.desafio_sicredi;

import java.time.Duration;
import java.time.Instant;

public class Sessao {

    private Long id_pauta;

    public Sessao(Long id_pauta) {
        this.id_pauta = id_pauta;
    }

    public Long getId_pauta() {
        return id_pauta;
    }
}
