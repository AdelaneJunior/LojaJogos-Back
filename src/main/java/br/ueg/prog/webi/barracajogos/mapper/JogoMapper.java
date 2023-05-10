package br.ueg.prog.webi.barracajogos.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.barracajogos.dto.JogoDTO;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JogoMapper extends BaseMapper<Jogo, JogoDTO> {
}
