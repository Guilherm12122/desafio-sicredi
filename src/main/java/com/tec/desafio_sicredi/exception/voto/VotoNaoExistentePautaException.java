package com.tec.desafio_sicredi.exception.voto;

public class VotoNaoExistentePautaException extends RuntimeException{
    public VotoNaoExistentePautaException(String msg) {
        super(msg);
    }
}
