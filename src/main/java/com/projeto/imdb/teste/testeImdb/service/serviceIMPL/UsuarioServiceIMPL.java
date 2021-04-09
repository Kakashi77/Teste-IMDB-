package com.projeto.imdb.teste.testeImdb.service.serviceIMPL;

import com.projeto.imdb.teste.testeImdb.dto.UsuarioDTO;
import com.projeto.imdb.teste.testeImdb.entity.Perfil;
import com.projeto.imdb.teste.testeImdb.entity.PerfilEnum;
import com.projeto.imdb.teste.testeImdb.entity.Usuario;
import com.projeto.imdb.teste.testeImdb.repository.PerfilRepository;
import com.projeto.imdb.teste.testeImdb.repository.UsuarioRepository;
import com.projeto.imdb.teste.testeImdb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceIMPL implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilRepository perfilRepository;


    @Override
    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDto) {
        Usuario usuario = this.converterUsuarioDtoaraUsuario(usuarioDto);
        this.verificaUsuario(usuario, usuarioDto.getIsAdministrador());
        usuarioRepository.save(usuario);
        return this.converterUsuarioParaUsuarioDto(usuario);
    }

    @Override
    public Boolean excluirUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuario.get().setBolAtivo(0);
            return true;
        }
        return false;
    }

    @Override
    public List<Usuario> listarUsuariosNaoAdmAtivo() {
        return usuarioRepository.retornaListaUsuariosNaoAdmAtivos();
    }

    @Override
    public UsuarioDTO editarUsuario(UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.retornaUsuarioSelecionado(dto.getId());
        usuario = recuperaEdicaoUsuario(dto, usuario);
        usuarioRepository.save(usuario);
        return this.converterUsuarioParaUsuarioDto(usuario);
    }

    private UsuarioDTO converterUsuarioParaUsuarioDto(Usuario usuario) {

        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail(usuario.getEmail());
        dto.setNome(usuario.getNome());
        dto.setBolAtivo(usuario.getBolAtivo());

        return dto;
    }

    private Usuario converterUsuarioDtoaraUsuario(UsuarioDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());
        usuario.setSenha(new BCryptPasswordEncoder().encode(dto.getSenha()));

        return usuario;
    }

    private Usuario recuperaEdicaoUsuario(UsuarioDTO dto, Usuario usuario) {

        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());
        usuario.setSenha(new BCryptPasswordEncoder().encode(dto.getSenha()));

        return usuario;
    }

    private void verificaUsuario(Usuario usuario, Boolean isAdministrador){

        List<Perfil> perfils = new ArrayList<>();
        if(isAdministrador){
            perfils.add(new Perfil("ROLE_ADMINISTRADOR",1l));
        }else{
            perfils.add(new Perfil("ROLE_USUARIO",2l));
        }
        usuario.setPerfis(perfils);
    }
}
