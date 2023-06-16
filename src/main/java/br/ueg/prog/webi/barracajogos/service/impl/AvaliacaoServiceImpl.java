package br.ueg.prog.webi.barracajogos.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.dto.AvaliacaoDTO;
import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import br.ueg.prog.webi.barracajogos.repository.AvaliacaoRepository;
import br.ueg.prog.webi.barracajogos.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AvaliacaoServiceImpl
        extends BaseCrudService <Avaliacao,Long, AvaliacaoRepository>
    implements AvaliacaoService{

    @Autowired
    private AvaliacaoRepository repository;
    @Override
    protected void prepararParaIncluir(Avaliacao entidade) {

    }

    @Override
    protected void validarDados(Avaliacao entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Avaliacao entidade) {

    }

    public float obterMediaJogo(Long jogoSeq) {
        return this.repository.obterMediaDoJogo(jogoSeq).get();
    }

    public List<Avaliacao> obterListaAvaliacaoPorJogo(Long jogoSeq) {
        return this.repository.obterListaAvaliacaoPorJogo(jogoSeq);
    }

    public int quantidadeAvaliacoesJogo(Long jogoSeq){
       return this.repository.quantidadeAvaliacoesJogo(jogoSeq).get();
    }

    public List<Jogo> obterJogosAvaliados() {
        return this.repository.obterJogosAvaliados();
    }
}