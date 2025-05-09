package com.tec.desafio_sicredi.service;

import com.tec.desafio_sicredi.dto.PautaDTO;
import com.tec.desafio_sicredi.exception.pauta.PautaExistenteDescricaoException;
import com.tec.desafio_sicredi.exception.pauta.PautaNaoExistenteException;
import com.tec.desafio_sicredi.exception.pauta.PautaNaoFechadaException;
import com.tec.desafio_sicredi.model.pauta.Pauta;
import com.tec.desafio_sicredi.repository.PautaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaService {
    @Autowired
    private PautaRepository repository;

    @Autowired
    private ModelMapper mapper;

    public void cadastrarPauta(PautaDTO pautaDTO){

        if (repository.getByDescricao(pautaDTO.getDescricao()).isPresent()) {
            throw new PautaExistenteDescricaoException("Já existe uma pauta com essa descrição");
        }

        repository.save(mapper.map(pautaDTO, Pauta.class));
    }

    public void validarPauta(Long id){

        Pauta pauta = repository.findById(id).orElseThrow(() -> new PautaNaoExistenteException(
                "Não existe uma pauta para esse código"));

        validarStatusPauta(mapper.map(pauta, PautaDTO.class));
    }

    private void validarStatusPauta(PautaDTO pautaDTO){
        if (!pautaDTO.getFechada()) {
            throw new PautaNaoFechadaException("Essa pauta ainda não foi fechada");
        }
    }

}
