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
@Table(name = Imagem.NOME_TABELA)
public class Imagem implements IEntidade<Long> {

    public static final String NOME_TABELA = "imagem";

    public static final class COLUNA {
        public static final String ID = "imgseq";
    }

    @SequenceGenerator(
            name = "a_gerador_sequence",
            sequenceName = "imagem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "a_gerador_sequence"
    )

    @Id
    @Column(name = "imgseq")
    private Long codigo;

    private String nome;

    private String tipo;

    private String caminhoArq;

    private String pathReference;

    @Override
    public String getTabelaNome() {return NOME_TABELA;}

    @Override
    public Long getId() {return this.codigo;}

    @Override
    public void setId(Long id) {this.codigo = id;}
}
