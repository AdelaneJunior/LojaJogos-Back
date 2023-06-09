package br.ueg.prog.webi.barracajogos.controller;

import br.ueg.prog.webi.api.controller.CrudController;
import br.ueg.prog.webi.barracajogos.dto.JogoDTO;
import br.ueg.prog.webi.barracajogos.mapper.JogoMapper;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import br.ueg.prog.webi.barracajogos.service.JogoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/${app.api.version}/jogo")
public class JogoController extends CrudController
        <Jogo, JogoDTO, Long, JogoMapper, JogoService> {

}
