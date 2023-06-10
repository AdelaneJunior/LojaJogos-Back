package br.ueg.prog.webi.barracajogos.dto;

import br.ueg.prog.webi.barracajogos.model.Jogo;
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

    private int nota;

    private String nomeJogo;
}

