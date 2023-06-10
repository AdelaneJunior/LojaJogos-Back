package br.ueg.prog.webi.barracajogos.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import br.ueg.prog.webi.barracajogos.repository.AvaliacaoRepository;
import br.ueg.prog.webi.barracajogos.service.AvaliacaoService;
import org.springframework.stereotype.Service;



@Service
public class AvaliacaoServiceImpl
        extends BaseCrudService <Avaliacao,Long, AvaliacaoRepository>
    implements AvaliacaoService{

    @Override
    protected void prepararParaIncluir(Avaliacao entidade) {

    }

    @Override
    protected void validarDados(Avaliacao entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Avaliacao entidade) {

    }}