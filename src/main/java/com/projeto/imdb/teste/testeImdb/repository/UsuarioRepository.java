package com.projeto.imdb.teste.testeImdb.repository;

import com.projeto.imdb.teste.testeImdb.entity.Filme;
import com.projeto.imdb.teste.testeImdb.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT U FROM Usuario  AS U WHERE U.id =?1")
    Usuario retornaUsuarioSelecionado(Long id);

    @Query("SELECT U FROM  Usuario  AS U  inner join U.perfis AS P WHERE U.bolAtivo = 1 and P.nome='ROLE_USUARIO'")
    List<Usuario> retornaListaUsuariosNaoAdmAtivos();

}
