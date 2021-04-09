package com.projeto.imdb.teste.testeImdb.repository;

import com.projeto.imdb.teste.testeImdb.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Long> {
}
