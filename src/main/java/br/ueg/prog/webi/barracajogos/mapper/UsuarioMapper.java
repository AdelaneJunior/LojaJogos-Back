package br.ueg.prog.webi.barracajogos.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.barracajogos.dto.UsuarioDTO;
import br.ueg.prog.webi.barracajogos.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {
}

