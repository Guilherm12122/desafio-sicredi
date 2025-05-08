package com.tec.desafio_sicredi.controller;

import com.tec.desafio_sicredi.dto.ApiResponse;
import com.tec.desafio_sicredi.dto.PautaDTO;
import com.tec.desafio_sicredi.service.PautaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PautaController {

    @Autowired
    PautaService pautaService;

    @PostMapping
    public ResponseEntity<ApiResponse> postPauta(@RequestBody @Valid PautaDTO pautaDTO){

        System.out.println(pautaDTO.getDescricao());

        pautaService.cadastrarPauta(pautaDTO);

        ApiResponse response = new ApiResponse(
                HttpStatus.CREATED.value(),
                "Pauta criada com sucesso"
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
