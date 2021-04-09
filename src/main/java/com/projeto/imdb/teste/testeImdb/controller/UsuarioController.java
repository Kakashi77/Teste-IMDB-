package com.projeto.imdb.teste.testeImdb.controller;

import com.projeto.imdb.teste.testeImdb.dto.UsuarioDTO;
import com.projeto.imdb.teste.testeImdb.entity.Usuario;
import com.projeto.imdb.teste.testeImdb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@Controller
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/cadastrarUsuario")
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuario, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/cadastrarUsuario").build().toUri();
        return ResponseEntity.created(uri).body(usuarioService.cadastrarUsuario(usuario));

    }

    @PreAuthorize("ADMINISTRADOR")
    @DeleteMapping("excluir/{id}")
    @Transactional
    public ResponseEntity<Boolean> excluirUsuario(@PathVariable Long id) {
        if (usuarioService.excluirUsuario(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listarUsuariosNaoAdmAtivo")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public List<Usuario> listarUsuariosNaoAdmAtivo() {
        List<Usuario> list = this.usuarioService.listarUsuariosNaoAdmAtivo();

        return list;
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('USUARIO')")
    @PutMapping
    @Transactional
    public ResponseEntity<UsuarioDTO> editarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.editarUsuario(usuarioDTO));
    }
}
