package br.ueg.prog.webi.barracajogos.model;

import br.ueg.prog.webi.api.model.IEntidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = br.ueg.prog.webi.barracajogos.model.Avaliacao.NOME_TABELA)
public class Avaliacao implements IEntidade<Long> {

    public static final String NOME_TABELA = "avaliacao";

    @SequenceGenerator(
            name = "a_gerador_sequence",
            sequenceName = "avaliacao_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "a_gerador_sequence"

    )

    @Id
    @Column(name = "avlseq")
    private Long codigo;

    @ManyToOne(optional = false)
    @JoinColumn(name = Jogo.Coluna.ID, nullable = false)
    private Jogo jogo;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = Usuario.Coluna.ID, nullable = false)
//    private Usuario valor;

    @Column(name = "descricao", length = 200, nullable = false)
    private String descricao;

    @Column(name = "nota", nullable = false)
    private int nota;

    @Transient
    private String nomeJogo;
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
