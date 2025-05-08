package com.tec.desafio_sicredi.exception;

import com.tec.desafio_sicredi.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PautaExistenteDescricaoException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handlePautaExistenteCadastro(
            PautaExistenteDescricaoException exception
    ){
        ApiResponse response = new ApiResponse(HttpStatus.CONFLICT.value(),
                exception.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
