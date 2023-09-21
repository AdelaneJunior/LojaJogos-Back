package br.ueg.prog.webi.barracajogos.model;

import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Getter
@Table(name = Usuario.NOME_TABELA)
public class Usuario extends BaseEntidade<Long> {

    public static final String NOME_TABELA = "usuario";

    public static final class Coluna {
        public static final String ID = "userid";
    }

    @SequenceGenerator(
            name = "a_gerador_sequence",
            sequenceName = "usuario_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "a_gerador_sequence"

    )

    @Id
    @Column(name = Usuario.Coluna.ID)
    private Long codigo;

    @Column(name = "userlgin", length = 200, nullable = false, unique = true)
    private String login;

    @Column(name = "usersnha", length = 200, nullable = false)
    private String senha;

    @Column(name = "usernome", length = 200, nullable = false, unique = true)
    private String nome;

    @Column(name = "usermail", length = 200, nullable = false)
    private String email;

    @Column(name = "userstat", nullable = false)
    private boolean status;

    @Column(name = "userrole", length = 200, nullable = true)
    private String role;

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
