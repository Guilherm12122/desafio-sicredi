package com.tec.desafio_sicredi.service;

import com.tec.desafio_sicredi.dto.AssociadoDTO;
import com.tec.desafio_sicredi.dto.PautaDTO;
import com.tec.desafio_sicredi.exception.associado.AssociadoNaoExisteException;
import com.tec.desafio_sicredi.exception.pauta.PautaNaoExistenteException;
import com.tec.desafio_sicredi.model.associado.Associado;
import com.tec.desafio_sicredi.model.pauta.Pauta;
import com.tec.desafio_sicredi.repository.AssociadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociadoService {

    @Autowired
    private AssociadoRepository repository;

    @Autowired
    private ModelMapper mapper;

    public void verificarSeAssociadoExiste(Long id){

        if (repository.findById(id).isEmpty()) {
            throw new AssociadoNaoExisteException("Não existe associado para esse id !");
        }
    }

    public AssociadoDTO obterAssociadoById(Long id){

        Associado associado = repository.findById(id).orElseThrow(() -> new AssociadoNaoExisteException(
                "Não existe associado para esse id !"));

        return mapper.map(associado, AssociadoDTO.class);
    }

}
