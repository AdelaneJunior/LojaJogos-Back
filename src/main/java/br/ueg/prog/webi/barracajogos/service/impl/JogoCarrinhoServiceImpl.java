package br.ueg.prog.webi.barracajogos.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.model.JogoCarrinho;
import br.ueg.prog.webi.barracajogos.model.Pks.PkJogoCarrinho;
import br.ueg.prog.webi.barracajogos.repository.JogoCarrinhoRepository;
import br.ueg.prog.webi.barracajogos.service.JogoCarrinhoService;
import org.springframework.stereotype.Service;


@Service
public class JogoCarrinhoServiceImpl
        extends BaseCrudService <JogoCarrinho, PkJogoCarrinho, JogoCarrinhoRepository>
    implements JogoCarrinhoService {

    @Override
    protected void prepararParaIncluir(JogoCarrinho entidade) {

    }

    @Override
    protected void validarDados(JogoCarrinho entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(JogoCarrinho entidade) {

    }
}