package br.ueg.prog.webi.barracajogos.model;

import br.ueg.prog.webi.api.model.BaseEntidade;
import br.ueg.prog.webi.barracajogos.model.Pks.PkJogoCarrinho;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@Entity
@Getter
@Table(name = JogoCarrinho.NOME_TABELA)
@IdClass(PkJogoCarrinho.class)
public class JogoCarrinho extends BaseEntidade<PkJogoCarrinho> {

    public static final String NOME_TABELA = "jogo_carrinho";

    public static final class Coluna {

        public static final String JOGO = "jocar_jogo";
        public static final String CARRINHO = "jocar_carrinho";
        public static final String QUANTIDADE = "jocar_quantidade";
        public static final String DESCONTO ="jocar_desconto";
    }


    @Id
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
    private BigDecimal desconto;

    @Transient
    private BigDecimal precoFinal;

    @Transient
    private BigDecimal precoUnitario;

    @Transient
    private Boolean temDesconto;
}
