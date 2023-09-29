package br.ueg.prog.webi.barracajogos.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.model.JogoCarrinho;
import br.ueg.prog.webi.barracajogos.model.Pks.PkJogoCarrinho;
import br.ueg.prog.webi.barracajogos.repository.JogoCarrinhoRepository;
import br.ueg.prog.webi.barracajogos.service.JogoCarrinhoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


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

    public BigDecimal tratarPrecoJogoPorQuantidadeEDesconto(JogoCarrinho jogoCarrinho){

        BigDecimal valorJogo = jogoCarrinho.getJogo().getValor();
        BigDecimal desconto = valorJogo.multiply(jogoCarrinho.getDesconto().divide(BigDecimal.valueOf(100), RoundingMode.HALF_EVEN));
        BigDecimal valorComDesconto = valorJogo.subtract(desconto);

        return  valorComDesconto.multiply(BigDecimal.valueOf(jogoCarrinho.getQuantidade())).setScale(2,RoundingMode.HALF_EVEN);

    }

    public void tratarPrecoJogoPorQuantidadeEDescontoList(List<JogoCarrinho> jogoCarrinhoList){

        for(JogoCarrinho jogoCarrinho : jogoCarrinhoList) {

            BigDecimal valorJogo = jogoCarrinho.getJogo().getValor();
            BigDecimal desconto = valorJogo.multiply(jogoCarrinho.getDesconto().divide(BigDecimal.valueOf(100)));
            BigDecimal valorComDesconto = valorJogo.subtract(desconto);

            jogoCarrinho.setPrecoFinal(valorComDesconto.multiply(BigDecimal.valueOf(jogoCarrinho.getQuantidade())));

        }
    }

    @Override
    public List<JogoCarrinho> listarTodos() {
        List<JogoCarrinho> jogoCarrinhoList = super.listarTodos();
        tratarPrecoJogoPorQuantidadeEDescontoList(jogoCarrinhoList);
        return jogoCarrinhoList;
    }
}