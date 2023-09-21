package br.ueg.prog.webi.barracajogos.enums;

import java.util.Arrays;

public enum Status {

    ATIVO("A", "Ativo"), INATIVO("I", "Inativo");

    private final String id;

    private final String descricao;

    /**
     * Construtor da classe.
     *
     * @param id        -
     * @param descricao -
     */
    Status(final String id, final String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna a instância de {@link Status} conforme o 'id' informado.
     *
     * @param id -
     * @return -
     */
    public static Status getById(final String id) {
        return Arrays.stream(values()).filter(value -> value.getId().equals(id)).findFirst().orElse(null);
    }

}

