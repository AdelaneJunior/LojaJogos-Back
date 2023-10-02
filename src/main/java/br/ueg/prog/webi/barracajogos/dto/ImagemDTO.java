package br.ueg.prog.webi.barracajogos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImagemDTO {

    private Long codigo;

    private String nome;

    private String tipo;

    private String caminhoArq;

    private String pathReference;
}
