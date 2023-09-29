package br.ueg.prog.webi.barracajogos.repository;

import br.ueg.prog.webi.barracajogos.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho,Long> {

    @Query("select carrinho from Carrinho carrinho " +
            "left join fetch carrinho.jogoCarrinho where" +
            " carrinho.codigo = :codigo")
    Optional<Carrinho> findById(@Param("codigo") Long codigo);

}
