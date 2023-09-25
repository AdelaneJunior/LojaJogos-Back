package br.ueg.prog.webi.barracajogos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoDTO {

    private Long codigo;

    private BigDecimal precoFinal;

    private List<JogoCarrinhoDTO> jogos;
}
