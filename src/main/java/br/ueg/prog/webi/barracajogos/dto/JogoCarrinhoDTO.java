package br.ueg.prog.webi.barracajogos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JogoCarrinhoDTO {

    private Long jogoCodigo;

    private Long carrinhoCodigo;

    private Long quantidade;

    private Float desconto;
}
