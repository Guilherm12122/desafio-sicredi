package com.tec.desafio_sicredi.service;

import com.tec.desafio_sicredi.dto.PautaDTO;
import com.tec.desafio_sicredi.exception.pauta.PautaExistenteDescricaoException;
import com.tec.desafio_sicredi.exception.pauta.PautaFechadaException;
import com.tec.desafio_sicredi.exception.pauta.PautaNaoExistenteException;
import com.tec.desafio_sicredi.exception.pauta.PautaNaoFechadaException;
import com.tec.desafio_sicredi.model.pauta.Pauta;
import com.tec.desafio_sicredi.repository.PautaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public void fecharPautaById(Long id){

        PautaDTO pautaDTO = obterPautaById(id);
        pautaDTO.setFechada(true);
        repository.save(mapper.map(pautaDTO, Pauta.class));
        System.out.println("SESSÃO FECHADA");

    }

    public PautaDTO obterPautaById(Long id){
        Pauta pauta = repository.findById(id).orElseThrow(() -> new PautaNaoExistenteException(
                "Não existe uma pauta para esse código"));

        return mapper.map(pauta, PautaDTO.class);
    }

    public void validarSePautaAberta(Long id_pauta){
        if (obterPautaById(id_pauta).getFechada()) {
            throw new PautaFechadaException("Essa pauta já foi fechada");
        }
    }

    public void validarSePautaFechada(Long id_pauta){
        if (!obterPautaById(id_pauta).getFechada()) {
            throw new PautaNaoFechadaException("Essa pauta ainda não foi fechada");
        }
    }

}
