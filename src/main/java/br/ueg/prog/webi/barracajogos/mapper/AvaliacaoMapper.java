package br.ueg.prog.webi.barracajogos.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.barracajogos.dto.AvaliacaoDTO;
import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AvaliacaoMapper extends BaseMapper<Avaliacao, AvaliacaoDTO> {

    @Override
    @Mapping(source = "jogoSeq", target = "jogo.codigo")
    @Mapping(source = "usuaseq", target = "usuario.codigo")
    Avaliacao toModelo(AvaliacaoDTO avaliacaoDTO);

    @Override
    @Mapping(source = "jogo.codigo", target = "jogoSeq")
    @Mapping(source = "jogo.nome", target = "nomeJogo")
    @Mapping(source = "usuario.codigo", target = "usuaseq")
    @Mapping(source = "usuario.nome", target = "nomeUsuario")
    AvaliacaoDTO toDTO(Avaliacao modelo);
}
