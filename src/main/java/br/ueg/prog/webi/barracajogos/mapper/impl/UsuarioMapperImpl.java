package br.ueg.prog.webi.barracajogos.mapper.impl;

import br.ueg.prog.webi.barracajogos.dto.UsuarioDTO;
import br.ueg.prog.webi.barracajogos.mapper.UsuarioMapper;
import br.ueg.prog.webi.barracajogos.model.Usuario;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class UsuarioMapperImpl implements UsuarioMapper {
    @Override
    public Usuario toModelo(UsuarioDTO modelo) {
        Usuario usuario = new Usuario();
        usuario.setCodigo(modelo.getCodigo());
        usuario.setLogin(modelo.getLogin());
        usuario.setStatus(modelo.isStatus());
        usuario.setRole(modelo.getRole());
        usuario.setEmail(modelo.getEmail());
        usuario.setNome(modelo.getNome());
        usuario.setSenha(modelo.getSenha());
        return usuario;
    }

    @Override
    public UsuarioDTO toDTO(Usuario modelo) {


        return UsuarioDTO.builder()
                .codigo(modelo.getCodigo())
                .login(modelo.getLogin())
                .status(modelo.isStatus())
                .role(modelo.getRole())
                .email(modelo.getEmail())
                .nome(modelo.getNome())
                .senha(modelo.getSenha())
                .build()
                ;
    }

    @Override
    public List<UsuarioDTO> toDTO(List<Usuario> lista) {
        List<UsuarioDTO> listaDTO = new ArrayList<>();

        lista.forEach(item -> {
            listaDTO.add(toDTO(item));
        });

        return listaDTO;
    }
}
