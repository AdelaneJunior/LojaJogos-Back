package br.ueg.prog.webi.barracajogos.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.model.Usuario;
import br.ueg.prog.webi.barracajogos.repository.UsuarioRepository;
import br.ueg.prog.webi.barracajogos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseCrudService<Usuario, Long, UsuarioRepository>
        implements UsuarioService {


    @Autowired
    UsuarioRepository repository;

    @Override
    protected void prepararParaIncluir(Usuario entidade) {

    }

    @Override
    protected void validarDados(Usuario entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Usuario entidade) {

    }

    public Usuario obterPeloLogin(String username) {

        return this.repository.obterPeloLogin(username);

    }

    public Usuario incluir(Usuario usuario) {
        this.validarCamposObrigatorios(usuario);
        this.validarDados(usuario);
        this.prepararParaIncluir(usuario);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senhaCodificada = bCryptPasswordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCodificada);
        return this.repository.save(usuario);

    }

}
