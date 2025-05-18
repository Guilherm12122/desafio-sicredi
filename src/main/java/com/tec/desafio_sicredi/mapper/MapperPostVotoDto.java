package com.tec.desafio_sicredi.mapper;

import com.tec.desafio_sicredi.dto.voto.PostVotoDto;
import com.tec.desafio_sicredi.model.associado.Associado;
import com.tec.desafio_sicredi.model.pauta.Pauta;
import com.tec.desafio_sicredi.model.voto.Voto;
import com.tec.desafio_sicredi.model.voto.VotoId;
import com.tec.desafio_sicredi.service.AssociadoService;
import com.tec.desafio_sicredi.service.PautaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperPostVotoDto {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PautaService pautaService;

    @Autowired
    private AssociadoService associadoService;

    public Voto converterParaEntidade(PostVotoDto postVotoDto){

        Voto voto = mapper.map(postVotoDto, Voto.class);

        voto.setAssociado(mapper.map(associadoService.obterAssociadoById(postVotoDto.getAssociado_id()), Associado.class));
        voto.setPauta(mapper.map(pautaService.obterPautaById(postVotoDto.getPauta_id()), Pauta.class));
        voto.setVotoId(new VotoId(postVotoDto.getAssociado_id(), postVotoDto.getPauta_id()));

        return voto;
    }
}
