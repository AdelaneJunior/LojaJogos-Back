package br.ueg.prog.webi.barracajogos.repository;

import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {


    @Query(value = "SELECT avg(a.nota) FROM Avaliacao a WHERE a.jogo.codigo = :jogoseq")
    Optional<Float> obterMediaDoJogo(@Param("jogoseq") Long jogoSeq);

    @Query(value = "SELECT a FROM Avaliacao a WHERE a.jogo.codigo = :jogoseq")
    List<Avaliacao> obterListaAvaliacaoPorJogo(@Param("jogoseq") Long jogoSeq);

    @Query(value = "SELECT count(a) FROM Avaliacao a WHERE a.jogo.codigo = :jogoSeq")
    Optional<Integer> quantidadeAvaliacoesJogo(@Param("jogoSeq") Long jogoSeq);

    @Query(value = "SELECT distinct a.jogo FROM Avaliacao a")
    List<Jogo> obterJogosAvaliados();
}
