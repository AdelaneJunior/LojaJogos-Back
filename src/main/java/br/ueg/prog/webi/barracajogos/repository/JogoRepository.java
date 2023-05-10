package br.ueg.prog.webi.barracajogos.repository;

import br.ueg.prog.webi.barracajogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
