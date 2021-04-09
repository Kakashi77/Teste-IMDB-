package com.projeto.imdb.teste.testeImdb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String senha;

    private String email;

    private Integer bolAtivo;

    private Boolean isAdministrador;

}
