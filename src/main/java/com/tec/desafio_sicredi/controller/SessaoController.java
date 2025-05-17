package com.tec.desafio_sicredi.controller;

import com.tec.desafio_sicredi.dto.ApiResponse;
import com.tec.desafio_sicredi.dto.PautaDTO;
import com.tec.desafio_sicredi.service.SessaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sessao")
public class SessaoController {

    @Autowired
    SessaoService sessaoService;

    @GetMapping("/{pauta_id}")
    public ResponseEntity<ApiResponse> openSessao(@PathVariable Long pauta_id){

        sessaoService.abrirSessaoPauta(pauta_id);

        ApiResponse response = new ApiResponse(
                HttpStatus.CREATED.value(),
                "Sessão de votação aberta para a pauta" + pauta_id
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
