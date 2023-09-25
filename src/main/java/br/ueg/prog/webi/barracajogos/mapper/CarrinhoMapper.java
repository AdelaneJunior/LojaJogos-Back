package br.ueg.prog.webi.barracajogos.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.barracajogos.dto.CarrinhoDTO;
import br.ueg.prog.webi.barracajogos.model.Carrinho;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarrinhoMapper extends BaseMapper<Carrinho, CarrinhoDTO> {
}
