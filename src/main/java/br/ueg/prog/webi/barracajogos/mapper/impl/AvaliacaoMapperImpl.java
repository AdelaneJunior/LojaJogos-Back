package br.ueg.prog.webi.barracajogos.mapper.impl;

import br.ueg.prog.webi.barracajogos.dto.AvaliacaoDTO;
import br.ueg.prog.webi.barracajogos.mapper.AvaliacaoMapper;
import br.ueg.prog.webi.barracajogos.model.Avaliacao;
import br.ueg.prog.webi.barracajogos.model.Jogo;
import br.ueg.prog.webi.barracajogos.model.Usuario;
import br.ueg.prog.webi.barracajogos.service.impl.JogoServiceImpl;
import br.ueg.prog.webi.barracajogos.service.impl.UsuarioServiceImpl;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public class AvaliacaoMapperImpl implements AvaliacaoMapper {

    @Autowired
    private JogoServiceImpl jogoService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Override
    public Avaliacao toModelo(AvaliacaoDTO avaliacaoDTO) {
        return Avaliacao.builder()
                .jogo(this.jogoService.obterPeloId(avaliacaoDTO.getJogoSeq()))
                .usuario(this.usuarioService.obterPeloUsername(avaliacaoDTO.getNomeUsuario()))
                .descricao(avaliacaoDTO.getDescricao())
                .nota(avaliacaoDTO.getNota())
                .codigo(null)
                .mediaJogo(0)
                .build();

    }
    @Override
    public AvaliacaoDTO toDTO(Avaliacao avaliacao) {

        Jogo jogo = avaliacao.getJogo();
        Usuario usuario = avaliacao.getUsuario();

        return AvaliacaoDTO.builder()
                .codigo(avaliacao.getCodigo())
                .nota(avaliacao.getNota())
                .descricao(avaliacao.getDescricao())
                .jogoSeq(jogo.getCodigo())
                .nomeJogo(jogo.getNomeJogo())
                .media(Objects.nonNull(avaliacao.getMediaJogo())?avaliacao.getMediaJogo() : 0)
                .usuaseq(usuario.getCodigo())
                .nomeUsuario(usuario.getNome())
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

}
