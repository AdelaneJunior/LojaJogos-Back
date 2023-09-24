package br.ueg.prog.webi.barracajogos.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.model.Carrinho;
import br.ueg.prog.webi.barracajogos.model.JogoCarrinho;
import br.ueg.prog.webi.barracajogos.repository.CarrinhoRepository;
import br.ueg.prog.webi.barracajogos.service.CarrinhoService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class CarrinhoServiceImpl
        extends BaseCrudService <Carrinho, Long, CarrinhoRepository>
    implements CarrinhoService {
    @Override
    protected void prepararParaIncluir(Carrinho entidade) {

    }

    @Override
    protected void validarDados(Carrinho entidade) {

    }

    private void tratarJogoCarrinho(Carrinho carrinho){

        Set<JogoCarrinho> listaJogoCarrinho = new HashSet<>();

        if (Objects.nonNull(carrinho.getJogos())) {
            carrinho.getJogos().forEach(jogoCarrinho -> {

                if (Objects.isNull(jogoCarrinho.getCarrinho())) {
                    jogoCarrinho.setCarrinho(carrinho);
                    listaJogoCarrinho.add(jogoCarrinho);
                }

            });
        }
        carrinho.setJogos(listaJogoCarrinho);
    }

    @Override
    public Carrinho obterPeloId(Long id) {
        return (Carrinho) this.repository.findById(id).get();
    }

    @Override
    protected void validarCamposObrigatorios(Carrinho entidade) {

    }

    @Override
    public Carrinho incluir(Carrinho carrinho) {

        tratarJogoCarrinho(carrinho);
        return super.incluir(carrinho);
    }
}