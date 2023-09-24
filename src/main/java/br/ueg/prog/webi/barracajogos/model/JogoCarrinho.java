package br.ueg.prog.webi.barracajogos.model;

import br.ueg.prog.webi.api.model.BaseEntidade;
import br.ueg.prog.webi.barracajogos.model.Pks.PkJogoCarrinho;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import static br.ueg.prog.webi.barracajogos.model.JogoCarrinho.NOME_TABELA;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Getter
@Table(name = NOME_TABELA)
@IdClass(PkJogoCarrinho.class)
public class JogoCarrinho extends BaseEntidade<PkJogoCarrinho> {

    public static final String NOME_TABELA = "jogo_carrinho";

    public static final class Coluna {

        public static final String JOGO = "jocar_jogo";
        public static final String CARRINHO = "jocar_carrinho";
        public static final String QUANTIDADE = "jocar_quantidade";
        public static final String DESCONTO ="jocar_desconto";
    }

    @SequenceGenerator(
            name = "item_gerador_sequence",
            sequenceName = "jogocarrinho_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "item_gerador_sequence"

    )

    @Id
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = Coluna.JOGO, nullable = false,
            referencedColumnName = Jogo.COLUNA.ID,
            foreignKey = @ForeignKey(name = "fk_jogocarrinho_jogo"))
    private Jogo jogo;

    @Id
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = Coluna.CARRINHO, nullable = false,
            referencedColumnName = Carrinho.Coluna.ID,
            foreignKey = @ForeignKey(name = "fk_jogocarrinho_carrinho"))
    private Carrinho carrinho;

    @Column(name = Coluna.QUANTIDADE, nullable = false)
    private Long quantidade;

    @Column(name = Coluna.DESCONTO, nullable = false)
    private Double desconto;
}
