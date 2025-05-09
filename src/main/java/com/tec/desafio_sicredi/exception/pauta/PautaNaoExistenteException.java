package com.tec.desafio_sicredi.exception.pauta;

public class PautaNaoExistenteException extends RuntimeException{
    public PautaNaoExistenteException(String msg) {
        super(msg);
    }
}
