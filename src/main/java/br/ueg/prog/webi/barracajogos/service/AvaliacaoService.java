package br.ueg.prog.webi.barracajogos.service;

import br.ueg.prog.webi.api.service.CrudService;
import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoService extends CrudService<Avaliacao, Long> {

}
