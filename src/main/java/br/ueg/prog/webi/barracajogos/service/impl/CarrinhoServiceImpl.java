package br.ueg.prog.webi.barracajogos.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.model.Carrinho;
import br.ueg.prog.webi.barracajogos.model.JogoCarrinho;
import br.ueg.prog.webi.barracajogos.repository.CarrinhoRepository;
import br.ueg.prog.webi.barracajogos.service.CarrinhoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;

@Service
public class CarrinhoServiceImpl
        extends BaseCrudService <Carrinho, Long, CarrinhoRepository>
    implements CarrinhoService {
    @Override
    protected void prepararParaIncluir(Carrinho entidade) {
        tratarJogoCarrinho(entidade);
    }

    @Override
    protected void validarDados(Carrinho entidade) {

    }

    private void tratarJogoCarrinho(Carrinho carrinho){

        if (Objects.nonNull(carrinho.getJogos())) {
            carrinho.getJogos().forEach(jogoCarrinho -> {

                if (Objects.isNull(jogoCarrinho.getCarrinho())) {
                    jogoCarrinho.setCarrinho(new Carrinho());
                    jogoCarrinho.getCarrinho().setCodigo(carrinho.getCodigo());
                }
            });
        }
    }

    private BigDecimal tratarPrecoFinal(Carrinho carrinho) {

        BigDecimal precoFinal = BigDecimal.ZERO;

        for (JogoCarrinho jogoCarrinho : carrinho.getJogos()) {
            BigDecimal quantidade = BigDecimal.valueOf(jogoCarrinho.getQuantidade());
            BigDecimal valorJogo = jogoCarrinho.getJogo().getValor();
            BigDecimal desconto = valorJogo.multiply(jogoCarrinho.getDesconto().divide(BigDecimal.valueOf(100)));
            BigDecimal valorComDesconto = valorJogo.subtract(desconto);

            BigDecimal jogoCarrinhoValor = valorComDesconto.multiply(quantidade);
            precoFinal = precoFinal.add(jogoCarrinhoValor);
        }

        return precoFinal;
    }

    @Override
    public Carrinho obterPeloId(Long id) {

        Carrinho retorno = (Carrinho) this.repository.findById(id).get();

        if(Objects.isNull(retorno.getJogos())) {
            retorno.setJogos(new HashSet<>());
        }

        return retorno;
    }

    @Override
    protected void validarCamposObrigatorios(Carrinho entidade) {

    }

}