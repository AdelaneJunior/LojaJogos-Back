package br.ueg.prog.webi.barracajogos.model;

import br.ueg.prog.webi.api.model.IEntidade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Getter
@Table(name = Jogo.NOME_TABELA)
public class Jogo implements IEntidade<Long> {

    public static final String NOME_TABELA = "jogo";

    public static final class COLUNA {
        public static final String ID = "jogseq";
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
    @JoinColumn(name=Imagem.COLUNA.ID)
    private Imagem imagem;

    @Column(name = "jognome", length = 200, nullable = false)
    private String nomeJogo;

    @Column(name = "jogdsvd", length = 200, nullable = false)
    private String desenvolvedora;

    @Column(name = "jogcatg", length = 200, nullable = false)
    private String categoria;

    @Column(name = "jogvalr", nullable = false)
    private BigDecimal valor;

    @Column(name = "joglanc")
    private LocalDate dataLancamento;


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
