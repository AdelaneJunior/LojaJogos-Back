package br.ueg.prog.webi.barracajogos.controller;

import br.ueg.prog.webi.api.controller.CrudController;
import br.ueg.prog.webi.barracajogos.dto.CarrinhoDTO;
import br.ueg.prog.webi.barracajogos.mapper.CarrinhoMapperImpl;
import br.ueg.prog.webi.barracajogos.model.Carrinho;
import br.ueg.prog.webi.barracajogos.service.impl.CarrinhoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/${app.api.version}/carrinho")
public class CarrinhoController extends CrudController
        <Carrinho, CarrinhoDTO, Long, CarrinhoMapperImpl, CarrinhoServiceImpl> {


    @Override
    public ResponseEntity<CarrinhoDTO> ObterPorId(Long id) {
        return super.ObterPorId(id);
    }
}
