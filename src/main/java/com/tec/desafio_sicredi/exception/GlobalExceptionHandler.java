package com.tec.desafio_sicredi.exception;

import com.tec.desafio_sicredi.dto.ApiResponse;
import com.tec.desafio_sicredi.exception.associado.AssociadoNaoExisteException;
import com.tec.desafio_sicredi.exception.pauta.PautaExistenteDescricaoException;
import com.tec.desafio_sicredi.exception.pauta.PautaFechadaException;
import com.tec.desafio_sicredi.exception.pauta.PautaNaoExistenteException;
import com.tec.desafio_sicredi.exception.pauta.PautaNaoFechadaException;
import com.tec.desafio_sicredi.exception.sessao.SessaoJaAbertaPautaException;
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

    @ExceptionHandler(AssociadoNaoExisteException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handleAssociadoNaoExistente(
            AssociadoNaoExisteException exception
    ){
        return buildResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(SessaoJaAbertaPautaException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handleSessaoJaAberta(
            SessaoJaAbertaPautaException exception
    ){
        return buildResponse(HttpStatus.CONFLICT, exception.getMessage());
    }

    @ExceptionHandler(PautaFechadaException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handlePautaFechada(
            PautaFechadaException exception
    ){
        return buildResponse(HttpStatus.CONFLICT, exception.getMessage());
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
