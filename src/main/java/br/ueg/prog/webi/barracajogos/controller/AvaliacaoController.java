package br.ueg.prog.webi.barracajogos.controller;

import br.ueg.prog.webi.api.controller.CrudController;
import br.ueg.prog.webi.api.exception.MessageResponse;
import br.ueg.prog.webi.barracajogos.dto.AvaliacaoDTO;
import br.ueg.prog.webi.barracajogos.mapper.AvaliacaoMapperImpl;
import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import br.ueg.prog.webi.barracajogos.model.Usuario;
import br.ueg.prog.webi.barracajogos.service.impl.AvaliacaoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/${app.api.version}/avaliacao")
public class AvaliacaoController extends CrudController
        <Avaliacao, AvaliacaoDTO, Long, AvaliacaoMapperImpl, AvaliacaoServiceImpl> {

    @Autowired
    private AvaliacaoServiceImpl service;


    @Operation(operationId = "obterPorIdAvaliacao")
    public ResponseEntity<AvaliacaoDTO> obterPorId(Long id) {

        Avaliacao avaliacao = this.service.obterPeloId(id);

        return ResponseEntity.ok(this.mapper.toDTO(avaliacao));

    }

    @PostMapping
    @Operation(
            operationId = "incluirAvaliacao",
            description = "Método utilizado para realizar a inclusão de um entidade",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Entidade Incluida",
                    content = {@Content(
                            mediaType = "application/json"
                    )}
            ), @ApiResponse(
                    responseCode = "403",
                    description = "Acesso negado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            ), @ApiResponse(
                    responseCode = "400",
                    description = "Erro de Negócio",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            )}
    )
    public ResponseEntity<AvaliacaoDTO> incluir(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacaoIncluir = this.mapper.toModelo(avaliacaoDTO);
        avaliacaoIncluir.setId(null);
        System.out.println(avaliacaoIncluir);
        avaliacaoIncluir = this.service.incluir(avaliacaoIncluir);
        return ResponseEntity.ok(this.mapper.toDTO(avaliacaoIncluir));
    }

    @Operation(
            description = "Media geral do Jogo",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Media geral do Jogo",
                    content = {@Content(
                            mediaType = "application/json"
                    )}
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Registro não encontrado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            )})
    @GetMapping(value = "/api/${app.api.version}/avaliacao/mediajogo")
    public Double obterMediaJogo(@RequestParam Long jogoSeq) {

        return this.service.obterMediaJogo(jogoSeq);
    }

    @Operation(
            description = "Listagem das Avaliações por Jogo",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Listagem das Avaliações por Jogo",
                    content = {@Content(
                            mediaType = "application/json",
                            array = @ArraySchema
                    )}
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Registro não encontrado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            )})
    @GetMapping(value = "/api/${app.api.version}/avaliacao/avaliacoesJogo")
    public ResponseEntity<List<AvaliacaoDTO>> obterListaAvaliacaoPorJogo(Long jogoSeq) {

        List<Avaliacao> listaAvaliacao = this.service.obterListaAvaliacaoPorJogo(jogoSeq);

        return ResponseEntity.ok(this.mapper.toDTO(listaAvaliacao));
    }

    @Operation(
            description = "Quantidade de Avaliações por Jogo",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Quantidade de Avaliações por Jogo",
                    content = {@Content(
                            mediaType = "application/json"
                    )}
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Registro não encontrado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            )})
    @GetMapping(value = "/api/${app.api.version}/avaliacao/qtdAvaliacoesJogo")
    public ResponseEntity<Integer> quantidadeAvaliacoesJogo(Long jogoSeq) {
        return ResponseEntity.ok(this.service.quantidadeAvaliacoesJogo(jogoSeq));
    }

    @Operation(
            description = "Listagem de Jogos Avaliados",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Listagem de Jogos Avaliados",
                    content = {@Content(
                            mediaType = "application/json",
                            array = @ArraySchema
                    )}
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Registro não encontrado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            )})
    @GetMapping(value = "/api/${app.api.version}/avaliacao/jogosAvaliados")
    public ResponseEntity<List<Jogo>> obterJogosAvaliados() {
        return ResponseEntity.ok(this.service.obterJogosAvaliados());
    }


    @Operation(
            description = "Listagem de Jogos Avaliados com media",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Listagem de Jogos Avaliados com media",
                    content = {@Content(
                            mediaType = "application/json",
                            array = @ArraySchema
                    )}
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Registro não encontrado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            )})
    @GetMapping(value = "/api/${app.api.version}/avaliacao/jogosAvaliadosMedia")
    public ResponseEntity<List<AvaliacaoDTO>> obterJogosAvaliadosComMedia() {

        ResponseEntity<List<Jogo>> listaJogos = this.obterJogosAvaliados();
        List<Avaliacao> listaAvaliacao = new ArrayList<>();
        for (Jogo jogo : listaJogos.getBody()) {
            Double media = this.obterMediaJogo(jogo.getCodigo());
            listaAvaliacao.add(
                    Avaliacao.builder()
                            .jogo(jogo)
                            .mediaJogo(media)
                            .usuario(new Usuario())
                            .build()
            );
        }
        return ResponseEntity.ok(this.mapper.toDTO(listaAvaliacao));
    }

    @Operation(
            description = "Listagem das Avaliações por Usuario",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Listagem das Avaliações por Usuario",
                    content = {@Content(
                            mediaType = "application/json",
                            array = @ArraySchema
                    )}
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Registro não encontrado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            )})
    @GetMapping(value = "/api/${app.api.version}/avaliacao/avaliacoesUser")
    public ResponseEntity<List<AvaliacaoDTO>> obterListaAvaliacoesPorUsuario(Long userSeq) {

        List<Avaliacao> listaAvaliacao = this.service.obterListaAvaliacoesPorUsuario(userSeq);

        return ResponseEntity.ok(this.mapper.toDTO(listaAvaliacao));
    }
}
