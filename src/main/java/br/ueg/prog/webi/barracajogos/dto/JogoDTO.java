package br.ueg.prog.webi.barracajogos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class JogoDTO {

    private Long codigo;

    private String nomeJogo;

    private String desenvolvedora;

    private String categoria;

    private BigDecimal valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;

}
