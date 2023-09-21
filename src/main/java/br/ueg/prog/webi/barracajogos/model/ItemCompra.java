package br.ueg.prog.webi.barracajogos.model;

import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import static br.ueg.prog.webi.barracajogos.model.ItemCompra.NOME_TABELA;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Getter
@Table(name = NOME_TABELA)
public class ItemCompra extends BaseEntidade<Long> {

    public static final String NOME_TABELA = "item_compra";


    @SequenceGenerator(
            name = "item_gerador_sequence",
            sequenceName = "item_compra_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "item_gerador_sequence"

    )

    @Id
    private Long codigo;

    @ManyToOne(optional = false)
    @JoinColumn(name = Jogo.COLUNA.IMAGEM, nullable = false,
            referencedColumnName = Imagem.COLUNA.ID,
            foreignKey = @ForeignKey(name = "fk_jogo_imagem"))
    private Jogo jogo;

    @Column
    private Long quantidade;

    @Column
    private Double preco;
}
