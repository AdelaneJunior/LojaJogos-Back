package br.ueg.prog.webi.barracajogos.controller;

import br.ueg.prog.webi.api.controller.CrudController;
import br.ueg.prog.webi.api.exception.MessageResponse;
import br.ueg.prog.webi.barracajogos.dto.UsuarioDTO;
import br.ueg.prog.webi.barracajogos.mapper.UsuarioMapper;
import br.ueg.prog.webi.barracajogos.model.Usuario;
import br.ueg.prog.webi.barracajogos.service.impl.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/${app.api.version}/usuario")
public class UsuarioController extends CrudController<Usuario, UsuarioDTO, Long, UsuarioMapper, UsuarioServiceImpl> {


    @Override
    @Operation(operationId = "incluirUsuario")
    public ResponseEntity<UsuarioDTO> incluir(UsuarioDTO modeloDTO) {
        return super.incluir(modeloDTO);
    }

    @Override
    @Operation(operationId = "alterarUsuario")
    public ResponseEntity<UsuarioDTO> alterar(UsuarioDTO modeloDTO, Long id) {
        return super.alterar(modeloDTO, id);
    }

    @Override
    @Operation(operationId = "removerUsuario")
    public ResponseEntity<UsuarioDTO> remover(Long id) {
        return super.remover(id);
    }

    @Override
    @Operation(operationId = "listAllUsuario")
    public ResponseEntity<List<UsuarioDTO>> listAll() {
        return super.listAll();
    }

    @Override
    @Operation(operationId = "obterPorIdUsuario")
    public ResponseEntity<UsuarioDTO> ObterPorId(Long id) {
        return super.ObterPorId(id);
    }

    @Operation(
            description = "Obtendo Usuario por login",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "UsuarioDTO  sendo obtido atraves do login",
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
    @GetMapping(value = "obterPorlogin")
    public UsuarioDTO obterPorLogin(@RequestBody String username) {
        Usuario usuario = this.service.obterPeloLogin(username);
        return this.mapper.toDTO(usuario);
    }


}
