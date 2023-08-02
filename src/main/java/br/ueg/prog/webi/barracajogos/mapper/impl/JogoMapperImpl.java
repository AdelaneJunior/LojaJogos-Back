package br.ueg.prog.webi.barracajogos.mapper.impl;

import br.ueg.prog.webi.barracajogos.dto.JogoDTO;
import br.ueg.prog.webi.barracajogos.mapper.JogoMapper;
import br.ueg.prog.webi.barracajogos.model.Imagem;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import br.ueg.prog.webi.barracajogos.service.impl.ImagemServiceImpl;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class JogoMapperImpl implements JogoMapper {

    @Autowired
    private ImagemServiceImpl imagemService;

    @Override
    public Jogo toModelo(JogoDTO jogoDTO) {

        Imagem imagem = imagemService.obterPeloId(jogoDTO.getCodigoImagem());

        Jogo jogo = new Jogo();
        jogo.setCodigo(jogoDTO.getCodigo());
        jogo.setNomeJogo(jogoDTO.getNomeJogo());
        jogo.setValor(jogoDTO.getValor());
        jogo.setDesenvolvedora(jogoDTO.getDesenvolvedora());
        jogo.setDataLancamento(jogoDTO.getDataLancamento());
        jogo.setCategoria(jogoDTO.getCategoria());
        jogo.setImagem(imagem);

        return jogo;

    }

    @Override
    public JogoDTO toDTO(Jogo jogo) {

        Imagem imagem = imagemService.obterPeloId(jogo.getImagem().getId());

        return JogoDTO.builder()
                .codigo(jogo.getCodigo())
                .categoria(jogo.getCategoria())
                .valor(jogo.getValor())
                .nomeJogo(jogo.getNomeJogo())
                .dataLancamento(jogo.getDataLancamento())
                .desenvolvedora(jogo.getDesenvolvedora())
                .codigoImagem(imagem.getCodigo())
                .caminhoImagem(imagem.getPathReference())
                .build();
    }

    @Override
    public List<JogoDTO> toDTO(List<Jogo> lista) {

        List<JogoDTO> listaDTO = new ArrayList<>();

        lista.forEach(item ->{
            listaDTO.add(toDTO(item));
        });

        return listaDTO;

    }
}
