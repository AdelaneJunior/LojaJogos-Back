package br.ueg.prog.webi.barracajogos.repository;

import br.ueg.prog.webi.barracajogos.model.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem,Long> {
}
