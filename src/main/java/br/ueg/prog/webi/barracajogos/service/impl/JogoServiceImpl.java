package br.ueg.prog.webi.barracajogos.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import br.ueg.prog.webi.barracajogos.repository.JogoRepository;
import br.ueg.prog.webi.barracajogos.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogoServiceImpl
        extends BaseCrudService<Jogo, Long, JogoRepository>
        implements JogoService {

    @Autowired
    private JogoRepository repository;

    @Override
    protected void prepararParaIncluir(Jogo entidade) {

    }

    @Override
    protected void validarDados(Jogo entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Jogo entidade) {

    }

}