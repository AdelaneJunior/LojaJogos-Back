package br.ueg.prog.webi.barracajogos.controller;

import br.ueg.prog.webi.api.exception.MessageResponse;
import br.ueg.prog.webi.barracajogos.dto.ImagemDTO;
import br.ueg.prog.webi.barracajogos.mapper.ImagemMapperImpl;
import br.ueg.prog.webi.barracajogos.model.Imagem;
import br.ueg.prog.webi.barracajogos.service.impl.ImagemServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/${app.api.version}/imagem")
@PreAuthorize(value = "hasRole('ADMIN')")
public class ImagemController {

    @Autowired
    private ImagemServiceImpl service;
    @Autowired
    private ImagemMapperImpl mapper;

    @Operation(
            description = "upload de imagem",
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
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "/upload")
    public Long uploadImagem(@RequestParam MultipartFile imagemASalvar) throws IOException {

        return this.service.incluir(imagemASalvar);

    }

    @GetMapping
    public String obterPeloID(Long requestID){
        return this.service.obterPeloId(requestID).getPathReference();
    }


    @DeleteMapping(
            path = {"/{id}"}
    )
    @Operation(
            description = "Método utilizado para remover uma entidiade pela id informado",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Entidade Removida",
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
            ), @ApiResponse(
                    responseCode = "403",
                    description = "Acesso negado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            )}
    )
    public ImagemDTO remover(@PathVariable(name = "id") Long idImagem){
        Imagem imagem = this.service.excluir(idImagem);
        return this.mapper.toDTO(imagem);
    }

}
