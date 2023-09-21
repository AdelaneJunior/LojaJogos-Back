package br.ueg.prog.webi.barracajogos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvaliacaoDTO {

    private Long codigo;

    private Long jogoSeq;

    private String descricao;

    private Long nota;

    private String nomeJogo;

    private Double media;

    private String nomeUsuario;

    private Long usuaseq;
}

