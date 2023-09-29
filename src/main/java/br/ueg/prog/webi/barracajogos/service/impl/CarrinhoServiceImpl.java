package br.ueg.prog.webi.barracajogos.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.model.Carrinho;
import br.ueg.prog.webi.barracajogos.model.JogoCarrinho;
import br.ueg.prog.webi.barracajogos.repository.CarrinhoRepository;
import br.ueg.prog.webi.barracajogos.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;

@Service
public class CarrinhoServiceImpl
        extends BaseCrudService<Carrinho, Long, CarrinhoRepository>
        implements CarrinhoService {

    @Autowired
    private JogoCarrinhoServiceImpl jogoCarrinhoService;

    @Override
    protected void prepararParaIncluir(Carrinho entidade) {
    }

    @Override
    protected void validarDados(Carrinho entidade) {

    }

    private BigDecimal tratarPrecoFinal(Carrinho carrinho) {

        BigDecimal precoFinal = BigDecimal.ZERO;

        for (JogoCarrinho jogoCarrinho : carrinho.getJogoCarrinho()) {
            jogoCarrinho.setPrecoFinal(jogoCarrinhoService.tratarPrecoJogoPorQuantidadeEDesconto(jogoCarrinho));
            precoFinal = precoFinal.add(jogoCarrinho.getPrecoFinal());
        }

        return precoFinal;
    }

    @Override
    protected void validarCamposObrigatorios(Carrinho entidade) {

    }

    @Override
    public Carrinho obterPeloId(Long id) {

        Carrinho retorno = (Carrinho) this.repository.findById(id).get();

        if (Objects.isNull(retorno.getJogoCarrinho())) {
            retorno.setJogoCarrinho(new HashSet<>());
        }

        retorno.setPrecoFinal(tratarPrecoFinal(retorno));

        return retorno;
    }

    @Override
    public Carrinho alterar(Carrinho carrinho, Long id) {
        Carrinho carrinhoRetorno = super.alterar(carrinho, id);
        carrinhoRetorno.setPrecoFinal(tratarPrecoFinal(carrinhoRetorno));
        return carrinhoRetorno;
    }

    @Override
    public Carrinho incluir(Carrinho modelo) {
        Carrinho carrinhoRetorno = super.incluir(modelo);
        carrinhoRetorno.setPrecoFinal(tratarPrecoFinal(carrinhoRetorno));
        return carrinhoRetorno;
    }
}