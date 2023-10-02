package br.ueg.prog.webi.barracajogos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JogoCarrinhoDTO {

    private Long jogoCodigo;

    private Long carrinhoCodigo;

    private Long quantidade;

    private BigDecimal desconto;

    private BigDecimal precoFinal;

    private BigDecimal precoUnitario;

    private String jogoNome;

    private String caminhoImagemJogo;

    private Boolean temDesconto;
}
