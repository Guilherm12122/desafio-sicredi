package com.tec.desafio_sicredi.exception;

import com.tec.desafio_sicredi.dto.ApiResponse;
import com.tec.desafio_sicredi.exception.pauta.PautaExistenteDescricaoException;
import com.tec.desafio_sicredi.exception.pauta.PautaNaoExistenteException;
import com.tec.desafio_sicredi.exception.pauta.PautaNaoFechadaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ApiResponse> buildResponse(HttpStatus status, String message) {
        ApiResponse response = new ApiResponse(status.value(), message);
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(PautaExistenteDescricaoException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handlePautaExistenteCadastro(
            PautaExistenteDescricaoException exception
    ){
        return buildResponse(HttpStatus.CONFLICT, exception.getMessage());
    }

    @ExceptionHandler(PautaNaoExistenteException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handlePautaNaoExistente(
        PautaNaoExistenteException exception
    ){
        return buildResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(PautaNaoFechadaException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handlePautaNaoFechada(
            PautaNaoFechadaException exception
    ){
        return buildResponse(HttpStatus.ACCEPTED, exception.getMessage());
    }
}
