package com.tec.desafio_sicredi.dto;

public class ApiResponse {
    private int status;
    private String mensagem;

    public ApiResponse(int status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }
}
