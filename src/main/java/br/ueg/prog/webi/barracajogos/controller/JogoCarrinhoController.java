package br.ueg.prog.webi.barracajogos.controller;

import br.ueg.prog.webi.api.controller.CrudController;
import br.ueg.prog.webi.barracajogos.dto.JogoCarrinhoDTO;
import br.ueg.prog.webi.barracajogos.mapper.JogoCarrinhoMapperImpl;
import br.ueg.prog.webi.barracajogos.model.JogoCarrinho;
import br.ueg.prog.webi.barracajogos.model.Pks.PkJogoCarrinho;
import br.ueg.prog.webi.barracajogos.service.impl.JogoCarrinhoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/${app.api.version}/jogo_carrinho")
public class JogoCarrinhoController extends CrudController
        <JogoCarrinho, JogoCarrinhoDTO, PkJogoCarrinho, JogoCarrinhoMapperImpl, JogoCarrinhoServiceImpl> {

    @Override
    public ResponseEntity<JogoCarrinhoDTO> incluir(JogoCarrinhoDTO modeloDTO) {
        return super.incluir(modeloDTO);
    }
}
