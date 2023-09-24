package br.ueg.prog.webi.barracajogos.model.Pks;

import br.ueg.prog.webi.api.model.annotation.PkComposite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@PkComposite
@Data
public class PkJogoCarrinho implements Serializable {

    private Long jogo;
    private Long carrinho;

}
