package br.ueg.prog.webi.barracajogos.repository;

import br.ueg.prog.webi.barracajogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepositoryCustom{

    List<Jogo> localizarPorJogo(Jogo jogo);
}
