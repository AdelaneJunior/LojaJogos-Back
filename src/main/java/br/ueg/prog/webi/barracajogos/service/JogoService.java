package br.ueg.prog.webi.barracajogos.service;

import br.ueg.prog.webi.api.service.CrudService;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface JogoService extends CrudService<Jogo, Long> {

}
