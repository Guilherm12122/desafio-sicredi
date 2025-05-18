package com.tec.desafio_sicredi.controller;

import com.tec.desafio_sicredi.dto.ApiResponse;
import com.tec.desafio_sicredi.dto.voto.PostVotoDto;
import com.tec.desafio_sicredi.dto.voto.VotoDTO;
import com.tec.desafio_sicredi.service.VotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping
    public ResponseEntity<ApiResponse> postVoto(@RequestBody @Valid PostVotoDto postVotoDto){

        votoService.realizarVoto(postVotoDto);

        ApiResponse response = new ApiResponse(
                HttpStatus.CREATED.value(),
                "Voto registrado !"
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{pauta_id}")
    public ResponseEntity<ApiResponse> getResultado(@PathVariable Long pauta_id){

        ApiResponse response = new ApiResponse(
                HttpStatus.OK.value(),
                votoService.obterResultadoVotacaoPauta(pauta_id)
        );

        return ResponseEntity.ok(response);
    }

}
