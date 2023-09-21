package br.ueg.prog.webi.barracajogos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JogoDTO {

    private Long codigo;

    private Long codigoImagem;

    private String caminhoImagem;

    private String nomeJogo;

    private String desenvolvedora;

    private String categoria;

    private BigDecimal valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Temporal(TemporalType.DATE)
    private LocalDate dataLancamento;

}
