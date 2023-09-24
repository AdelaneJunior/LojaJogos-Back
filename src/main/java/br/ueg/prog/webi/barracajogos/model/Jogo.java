package br.ueg.prog.webi.barracajogos.model;

import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Getter
@Table(name = Jogo.NOME_TABELA)
public class Jogo extends BaseEntidade<Long> {

    public static final String NOME_TABELA = "jogo";

    public static final class COLUNA {
        public static final String ID = "jogseq";
        public static final String IMAGEM = "jogimagem";
        public static final String NOME = "jognome";
        public static final String DESENVOLVEDORA = "jogdesenvolvedora";
        public static final String CATEGORIA = "jogcategoria";
        public static final String VALOR = "jogvalor";
        public static final String LANCAMENTO = "joglancamento";
    }

    @SequenceGenerator(
            name = "a_gerador_sequence",
            sequenceName = "jogos_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "a_gerador_sequence"

    )

    @Id
    @Column(name = COLUNA.ID)
    private Long codigo;


    @ManyToOne(optional = false)
    @JoinColumn(name = COLUNA.IMAGEM, nullable = false,
            referencedColumnName = Imagem.COLUNA.ID,
            foreignKey = @ForeignKey(name = "fk_jogo_imagem"))
    private Imagem imagem;

    @Column(name = COLUNA.NOME, length = 200, nullable = false)
    private String nome;

    @Column(name = COLUNA.DESENVOLVEDORA, length = 200, nullable = false)
    private String desenvolvedora;

    @Column(name = COLUNA.CATEGORIA, length = 200, nullable = false)
    private String categoria;

    @Column(name = COLUNA.VALOR, nullable = false)
    private BigDecimal valor;

    @Temporal(TemporalType.DATE)
    @Column(name = COLUNA.LANCAMENTO)
    private LocalDate dataLancamento;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "jogo", fetch = FetchType.LAZY)
    private Set<JogoCarrinho> jogoCarrinhos;


    @Override
    public String getTabelaNome() {
        return NOME_TABELA;
    }

    @Override
    public Long getId() {
        return codigo;
    }

    @Override
    public void setId(Long id) {
        this.codigo = id;
    }
}
