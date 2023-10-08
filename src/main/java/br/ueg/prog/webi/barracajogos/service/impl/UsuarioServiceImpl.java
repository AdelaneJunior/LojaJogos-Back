package br.ueg.prog.webi.barracajogos.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.barracajogos.model.Carrinho;
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
    protected void prepararParaIncluir(Usuario usuario) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senhaCodificada = bCryptPasswordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCodificada);
        usuario.setRole("ROLE_USER");
        usuario.setCarrinho(new Carrinho());

    }

    @Override
    protected void validarDados(Usuario entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Usuario entidade) {

    }

    public Usuario obterPeloLogin(String login) {

        return this.repository.obterPeloLogin(login);

    }

    public Usuario obterPeloUsername(String username){
        return this.repository.obterPeloUsername(username);
    }

    public Usuario incluir(Usuario usuario) {
        String senha = usuario.getSenha();
        this.validarCamposObrigatorios(usuario);
        this.validarDados(usuario);
        this.prepararParaIncluir(usuario);
        usuario = this.repository.save(usuario);
        usuario.setSenha(senha);
        return usuario;
    }

}
