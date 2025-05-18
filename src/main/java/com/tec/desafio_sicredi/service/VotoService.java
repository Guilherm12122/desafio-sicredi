package com.tec.desafio_sicredi.service;

import com.tec.desafio_sicredi.dto.voto.PostVotoDto;
import com.tec.desafio_sicredi.dto.voto.VotoDTO;
import com.tec.desafio_sicredi.exception.voto.AssociadoJaVotouException;
import com.tec.desafio_sicredi.exception.voto.VotoNaoExistentePautaException;
import com.tec.desafio_sicredi.mapper.MapperPostVotoDto;
import com.tec.desafio_sicredi.model.voto.Voto;
import com.tec.desafio_sicredi.repository.VotoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoService {

    @Autowired
    private VotoRepository repository;

    @Autowired
    private PautaService pautaService;

    @Autowired
    private AssociadoService associadoService;

    @Autowired
    private MapperPostVotoDto mapperPostVotoDto;

    @Autowired
    SessaoService sessaoService;

    @Autowired
    private ModelMapper mapper;

    public void realizarVoto(PostVotoDto postVotoDto){

        sessaoService.validaSessaoAberta(postVotoDto.getPauta_id());

        if (verificarSeExisteVotoParaIds(postVotoDto.getPauta_id(), postVotoDto.getAssociado_id())) {

            Voto voto = mapperPostVotoDto.converterParaEntidade(postVotoDto);

            repository.save(voto);
            
        } else {
            throw new AssociadoJaVotouException("Esse associado já votou para essa pauta !");
        }
    }

    public boolean verificarSeExisteVotoParaIds(Long id_pauta, Long id_associado){
        return repository.getByAssociadoIdPautaId(id_pauta, id_associado).isEmpty();
    }

    public String obterResultadoVotacaoPauta(Long id_pauta){

        pautaService.validarSePautaFechada(id_pauta);

        List<Boolean> resultados_votos = validarVotoPauta(id_pauta).stream()
                .map(VotoDTO::getA_favor).toList();

        return avaliarResultadoVotacaoPauta(resultados_votos);
    }

    private String avaliarResultadoVotacaoPauta(List<Boolean> resultados){

        int qtdes_a_favor = resultados.stream().filter(r -> r).toList().size();
        int qtdes_contra = resultados.size() - qtdes_a_favor;

        String placar = qtdes_a_favor + " X " + qtdes_contra + ": ";

        return placar.concat(obterVereditoQtdeVotos(qtdes_a_favor, qtdes_contra));
    }

    private String obterVereditoQtdeVotos(Integer a_favor, Integer contra){
        if (a_favor > contra) return "PAUTA APROVADA";
        if (a_favor < contra) return "PAUTA NÃO APROVADA";
        return "INDEFINIDA";
    }

    private List<VotoDTO> validarVotoPauta(Long id_pauta){

        List<Voto> votos = repository.getVotosByIdPauta(id_pauta).orElseThrow(
                () -> new VotoNaoExistentePautaException("Não existe votos para essa pauta")
        );

        return votos.stream().map(v -> mapper.map(v, VotoDTO.class)).toList();
    }
}
