package br.ueg.prog.webi.barracajogos.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.barracajogos.dto.ImagemDTO;
import br.ueg.prog.webi.barracajogos.model.Imagem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImagemMapper extends BaseMapper<Imagem, ImagemDTO> {
}
