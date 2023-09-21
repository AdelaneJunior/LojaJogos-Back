package br.ueg.prog.webi.barracajogos.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.barracajogos.dto.JogoDTO;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JogoMapper extends BaseMapper<Jogo, JogoDTO> {

    @Override
    @Mapping(source = "codigoImagem", target = "imagem.codigo")
    Jogo toModelo(JogoDTO jogoDTO);

    @Override
    @Mapping(source = "imagem.codigo", target = "codigoImagem")
    @Mapping(source = "imagem.pathReference", target = "caminhoImagem")
    JogoDTO toDTO(Jogo jogo);
}
