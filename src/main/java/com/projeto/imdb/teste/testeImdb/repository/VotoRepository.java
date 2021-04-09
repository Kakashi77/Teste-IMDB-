package com.projeto.imdb.teste.testeImdb.repository;

import com.projeto.imdb.teste.testeImdb.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto,Long> {
}
