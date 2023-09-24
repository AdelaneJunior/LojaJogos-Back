package br.ueg.prog.webi.barracajogos.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.barracajogos.dto.UsuarioDTO;
import br.ueg.prog.webi.barracajogos.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {


    @Override
    @Mapping(source = "carrinhoCodigo", target = "carrinho.codigo")
    Usuario toModelo(UsuarioDTO usuarioDTO);

    @Override
    @Mapping(source = "carrinho.codigo", target = "carrinhoCodigo")
    UsuarioDTO toDTO(Usuario modelo);
}

