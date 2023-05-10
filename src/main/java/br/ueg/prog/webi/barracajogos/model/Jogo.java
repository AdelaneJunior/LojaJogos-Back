package br.ueg.prog.webi.barracajogos.model;

import br.ueg.prog.webi.api.model.IEntidade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Data
@Entity
@Table(name = Jogo.NOME_TABELA)
public class Jogo implements IEntidade<Long> {

    public static final String NOME_TABELA = "jogo";

    public static final String NOMEJOGO = "uk_nome_jogo";

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
    @Column(name = "jogseq")
    private Long codigo;

    @Column(name = "jognome", length = 200, nullable = false)
    private String nomeJogo;

    @Column(name = "jogdsvd", length = 200, nullable = false)
    private String desenvolvedora;

    @Column(name = "jogcatg", length = 200, nullable = false)
    private String categoria;

    @Column(name = "jogvalr", nullable = false)
    private BigDecimal valor;

    @Column(name = "joglanc")
    @Temporal(TemporalType.DATE)
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
