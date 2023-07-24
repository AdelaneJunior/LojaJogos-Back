package br.ueg.prog.webi.barracajogos.controller;

import br.ueg.prog.webi.api.exception.MessageResponse;
import br.ueg.prog.webi.barracajogos.service.impl.ImagemServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/${app.api.version}/imagem")
public class ImagemController {

    @Autowired
    private ImagemServiceImpl service;


    @Operation(description = "Adiciona um arquivo no storage", responses = {
            @ApiResponse(responseCode = "200", description = "Adiciona arquivo",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            ))
            ), @ApiResponse(
            responseCode = "403",
            description = "Acesso negado",
            content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = MessageResponse.class
                    ))
            })})
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "/upload")
    public String uploadImagem(@RequestParam MultipartFile imagemASalvar) throws IOException {

        return this.service.incluir(imagemASalvar).toString();

    }

}
