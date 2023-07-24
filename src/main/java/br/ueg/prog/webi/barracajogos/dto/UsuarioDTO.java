package br.ueg.prog.webi.barracajogos.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO{

    public Long codigo;

    public String login;

    public String senha;

    public String nome;

    public String email;

    public boolean status;

    public List<String> roles;
}
