package br.ueg.prog.webi.barracajogos.mapper.impl;

import br.ueg.prog.webi.barracajogos.dto.AvaliacaoDTO;
import br.ueg.prog.webi.barracajogos.mapper.AvaliacaoMapper;
import br.ueg.prog.webi.barracajogos.mapper.JogoMapper;
import br.ueg.prog.webi.barracajogos.mapper.JogoMapperImpl;
import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import br.ueg.prog.webi.barracajogos.service.impl.JogoServiceImpl;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class AvaliacaoMapperImpl implements AvaliacaoMapper {

    @Autowired
    public JogoServiceImpl jogoService;

    @Override
    public Avaliacao toModelo(AvaliacaoDTO avaliacaoDTO) {

        Jogo jogo = getJogo(avaliacaoDTO);

        return Avaliacao.builder()
                .jogo(jogo)
                .descricao(avaliacaoDTO.getDescricao())
                .nota(avaliacaoDTO.getNota())
                .codigo(null)
                .nomeJogo(jogo.getNomeJogo())
                .build();

    }

    @Override
    public AvaliacaoDTO toDTO(Avaliacao avaliacao) {

        Jogo jogo = avaliacao.getJogo();

        return AvaliacaoDTO.builder()
                .codigo(avaliacao.getCodigo())
                .nota(avaliacao.getNota())
                .descricao(avaliacao.getDescricao())
                .jogoSeq(jogo.getCodigo())
                .nomeJogo(jogo.getNomeJogo())
                .build();

    }

    @Override
    public List<AvaliacaoDTO> toDTO(List<Avaliacao> lista) {

        List<AvaliacaoDTO> listaDTO = new ArrayList<>();

        lista.forEach(item ->{
            listaDTO.add(toDTO(item));
        });

        return listaDTO;
    }


    private Jogo getJogo(AvaliacaoDTO avaliacaoDTO) {
        JogoMapper jogoMapper = new JogoMapperImpl();
        Jogo jogo = this.jogoService.obterPeloId(avaliacaoDTO.getJogoSeq());
        return jogo;
    }
}
