package br.ueg.prog.webi.barracajogos.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.barracajogos.dto.CarrinhoDTO;
import br.ueg.prog.webi.barracajogos.model.Carrinho;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarrinhoMapper extends BaseMapper<Carrinho, CarrinhoDTO> {

    @Override
    @Mapping(source = "jogos", target = "jogos")
    Carrinho toModelo(CarrinhoDTO carrinhoDTO);

    @Override
    @Mapping(source = "jogos", target = "jogos")
    CarrinhoDTO toDTO(Carrinho modelo);
}
