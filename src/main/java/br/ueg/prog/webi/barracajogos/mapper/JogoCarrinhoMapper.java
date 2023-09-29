package br.ueg.prog.webi.barracajogos.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.barracajogos.dto.JogoCarrinhoDTO;
import br.ueg.prog.webi.barracajogos.model.JogoCarrinho;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = JogoMapperImpl.class)
public interface JogoCarrinhoMapper extends BaseMapper<JogoCarrinho, JogoCarrinhoDTO> {

    @Override
    @Mapping(source = "jogoCodigo", target = "jogo.codigo")
    @Mapping(source = "carrinhoCodigo", target = "carrinho.codigo")
    JogoCarrinho toModelo(JogoCarrinhoDTO jogoCarrinhoDTO);

    @Override
    @Mapping(source = "carrinho.codigo", target = "carrinhoCodigo")
    @Mapping(source = "jogo.codigo", target = "jogoCodigo")
    @Mapping(source = "jogo.nome", target = "jogoNome")
    JogoCarrinhoDTO toDTO(JogoCarrinho modelo);


}
