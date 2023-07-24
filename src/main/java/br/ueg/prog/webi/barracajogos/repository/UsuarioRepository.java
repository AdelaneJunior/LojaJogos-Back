package br.ueg.prog.webi.barracajogos.repository;

import br.ueg.prog.webi.barracajogos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT user FROM Usuario user where user.login = :username")
    Usuario obterPeloLogin(@Param("username") String username);
}
