package br.ueg.prog.webi.barracajogos.repository;

import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {


    @Query(value = "SELECT a FROM Avaliacao a WHERE a.usuario = :userseq")
    List<Avaliacao> obterListaAvaliacoesPorUsuario(@Param("userseq")Long userseq);

    @Query("SELECT avg(a.nota) FROM Avaliacao a WHERE a.jogo.codigo = :jogoseq")
    Optional<Double> obterMediaDoJogo(@Param("jogoseq") Long jogoSeq);

    @Query("SELECT a FROM Avaliacao a WHERE a.jogo.codigo = :jogoseq")
    List<Avaliacao> obterListaAvaliacaoPorJogo(@Param("jogoseq") Long jogoSeq);

    @Query("SELECT count(a) FROM Avaliacao a WHERE a.jogo.codigo = :jogoSeq")
    Optional<Integer> quantidadeAvaliacoesJogo(@Param("jogoSeq") Long jogoSeq);

    @Query("SELECT distinct a.jogo FROM Avaliacao a")
    List<Jogo> obterJogosAvaliados();
}
