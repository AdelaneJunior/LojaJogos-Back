package br.ueg.prog.webi.barracajogos.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.barracajogos.dto.JogoCarrinhoDTO;
import br.ueg.prog.webi.barracajogos.model.JogoCarrinho;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JogoCarrinhoMapper extends BaseMapper<JogoCarrinho, JogoCarrinhoDTO> {

    @Override
    @Mapping(source = "jogoCodigo", target = "jogo.codigo")
    @Mapping(source = "carrinhoCodigo", target = "carrinho.codigo")
    JogoCarrinho toModelo(JogoCarrinhoDTO jogoCarrinhoDTO);

    @Override
    @Mapping(source = "jogo.codigo", target = "jogoCodigo")
    @Mapping(source = "carrinho.codigo", target = "carrinhoCodigo")
    JogoCarrinhoDTO toDTO(JogoCarrinho modelo);


}
