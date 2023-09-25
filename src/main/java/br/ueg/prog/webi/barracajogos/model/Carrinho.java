package br.ueg.prog.webi.barracajogos.model;

import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Getter
@Table(name = Carrinho.NOME_TABELA)
public class Carrinho extends BaseEntidade<Long> {

    public static final String NOME_TABELA = "carrinho";

    public static final class Coluna {

        public static final String ID = "carr_codigo";
        public static final String PRECO_FINAL = "carr_precofinal";
    }



    @SequenceGenerator(
            name = "item_gerador_sequence",
            sequenceName = "carrinho_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "item_gerador_sequence"

    )

    @Id
    @Column(name = Coluna.ID)
    private Long codigo;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "carrinho",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Set<JogoCarrinho> jogos = new HashSet<>();

    @Transient
    private BigDecimal precoFinal;
}
