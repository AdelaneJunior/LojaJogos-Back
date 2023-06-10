package br.ueg.prog.webi.barracajogos.controller;

import br.ueg.prog.webi.api.controller.CrudController;
import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.dto.AvaliacaoDTO;
import br.ueg.prog.webi.barracajogos.dto.JogoDTO;
import br.ueg.prog.webi.barracajogos.mapper.AvaliacaoMapper;
import br.ueg.prog.webi.barracajogos.mapper.JogoMapper;
import br.ueg.prog.webi.barracajogos.mapper.JogoMapperImpl;
import br.ueg.prog.webi.barracajogos.mapper.impl.AvaliacaoMapperImpl;
import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import br.ueg.prog.webi.barracajogos.repository.JogoRepository;
import br.ueg.prog.webi.barracajogos.service.AvaliacaoService;
import br.ueg.prog.webi.barracajogos.service.impl.JogoServiceImpl;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/${app.api.version}/avaliacao")
public class AvaliacaoController extends CrudController
        <Avaliacao, AvaliacaoDTO, Long, AvaliacaoMapperImpl, AvaliacaoService> {

    public ResponseEntity<AvaliacaoDTO> ObterPorId(Long id){

        Avaliacao avaliacao = this.service.obterPeloId(id);

        return ResponseEntity.ok(this.mapper.toDTO(avaliacao));

    }
    public ResponseEntity<AvaliacaoDTO> incluir(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacaoIncluir = this.mapper.toModelo(avaliacaoDTO);
        avaliacaoIncluir.setId(null);
        System.out.println(avaliacaoIncluir);
        avaliacaoIncluir = this.service.incluir(avaliacaoIncluir);
        return ResponseEntity.ok(this.mapper.toDTO(avaliacaoIncluir));
    }


}
