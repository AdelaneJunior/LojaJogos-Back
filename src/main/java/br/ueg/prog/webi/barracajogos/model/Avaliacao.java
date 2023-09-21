package br.ueg.prog.webi.barracajogos.model;

import br.ueg.prog.webi.api.model.BaseEntidade;
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
@Table(name = Avaliacao.NOME_TABELA)
public class Avaliacao extends BaseEntidade<Long> {

    public static final String NOME_TABELA = "avaliacao";

    public static class COLUNA{

        public static final String CODIGO = "avlid";
        public static final String JOGO = "avljogo";
        public static final String USUARIO = "avlusuario";
        public static final String DESCRICAO = "avldescricao";
        public static final String NOTA =  "avlnota";

    }

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
    @Column(name = COLUNA.CODIGO)
    private Long codigo;

    @ManyToOne(optional = false)
    @JoinColumn(name = COLUNA.JOGO, nullable = false,
            referencedColumnName = Jogo.COLUNA.ID,
            foreignKey = @ForeignKey(name = "fk_avaliacao_jogo"))
    private Jogo jogo;

    @ManyToOne(optional = false)
    @JoinColumn(name = COLUNA.USUARIO, nullable = false,
            referencedColumnName = Usuario.Coluna.ID,
            foreignKey = @ForeignKey(name = "fk_avaliacao_usuario"))
    private Usuario usuario;

    @Column(name = COLUNA.DESCRICAO, length = 200, nullable = false)
    private String descricao;

    @Column(name = COLUNA.NOTA, nullable = false)
    private Long nota;

    @Transient
    private Double mediaJogo;

}
