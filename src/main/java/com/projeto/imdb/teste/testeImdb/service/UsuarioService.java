package com.projeto.imdb.teste.testeImdb.service;

import com.projeto.imdb.teste.testeImdb.dto.UsuarioDTO;
import com.projeto.imdb.teste.testeImdb.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    UsuarioDTO cadastrarUsuario(UsuarioDTO usuario);

    Boolean excluirUsuario(Long id);

    List<Usuario> listarUsuariosNaoAdmAtivo();

    UsuarioDTO editarUsuario(UsuarioDTO dto);
}
