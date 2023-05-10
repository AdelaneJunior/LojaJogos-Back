package br.ueg.prog.webi.barracajogos.mapper.impl;

import br.ueg.prog.webi.barracajogos.dto.JogoDTO;
import br.ueg.prog.webi.barracajogos.mapper.JogoMapper;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class JogoMapperImpl implements JogoMapper {

    @Override
    public Jogo toModelo(JogoDTO jogoDTO) {

        Jogo jogo = new Jogo();
        jogo.setNomeJogo(jogoDTO.getNomeJogo());
        jogo.setCategoria(jogoDTO.getCategoria());
        jogo.setValor(jogoDTO.getValor());
        jogo.setDesenvolvedora(jogoDTO.getDesenvolvedora());
        jogo.setCodigo(jogoDTO.getCodigo());
        jogo.setDataLancamento(jogoDTO.getDataLancamento());

        return jogo;
    }

    @Override
    public JogoDTO toDTO(Jogo modelo) {

        JogoDTO jogoDTO = new JogoDTO();
        jogoDTO.setNomeJogo(modelo.getNomeJogo());
        jogoDTO.setCategoria(modelo.getCategoria());
        jogoDTO.setValor(modelo.getValor());
        jogoDTO.setDesenvolvedora(modelo.getDesenvolvedora());
        jogoDTO.setCodigo(modelo.getCodigo());
        jogoDTO.setDataLancamento(modelo.getDataLancamento());

        return jogoDTO;
    }

    @Override
    public List<JogoDTO> toDTO(List<Jogo> lista) {

        List<JogoDTO> jogosDTO = new ArrayList<>();

        for(Jogo jogo : lista){
            JogoDTO jogoDTO = toDTO(jogo);
            jogosDTO.add(jogoDTO);
        }

        return jogosDTO;
    }

}
