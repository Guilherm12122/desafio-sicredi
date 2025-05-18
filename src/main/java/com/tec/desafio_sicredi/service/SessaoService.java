package com.tec.desafio_sicredi.service;

import com.tec.desafio_sicredi.Sessao;
import com.tec.desafio_sicredi.exception.sessao.SessaoFechadaException;
import com.tec.desafio_sicredi.exception.sessao.SessaoJaAbertaPautaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SessaoService {

    @Autowired
    PautaService pautaService;
    private List<Sessao> sessoes = new ArrayList<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(200);

    public void abrirSessaoPauta(Long id_pauta){

        pautaService.validarSePautaAberta(id_pauta);

        if (!sessoes.stream().anyMatch(s -> Objects.equals(s.getId_pauta(), id_pauta))) {

            Sessao sessao = new Sessao(id_pauta);

            sessoes.add(sessao);

            scheduler.schedule(() ->{
                sessoes.remove(sessao);
                pautaService.fecharPautaById(id_pauta);
            }, 60, TimeUnit.SECONDS);

        } else {
            throw new SessaoJaAbertaPautaException("A sessão para essa pauta já está aberta !");
        }
    }


    public void validaSessaoAberta(Long id_sessao){

        boolean status = sessoes.stream().anyMatch(s -> Objects.equals(s.getId_pauta(), id_sessao));

        if (!status) {
            throw new SessaoFechadaException("A sessão para essa pauta não está aberta !");
        }

    }
}
