package com.tec.desafio_sicredi.exception.pauta;

public class PautaNaoFechadaException extends RuntimeException{
    public PautaNaoFechadaException(String msg) {
        super(msg);
    }
}
