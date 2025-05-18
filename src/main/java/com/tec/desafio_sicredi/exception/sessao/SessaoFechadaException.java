package com.tec.desafio_sicredi.exception.sessao;

public class SessaoFechadaException extends RuntimeException {
    public SessaoFechadaException(String msg){
        super(msg);
    }
}
