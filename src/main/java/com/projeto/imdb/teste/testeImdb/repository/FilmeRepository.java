package com.projeto.imdb.teste.testeImdb.repository;

import com.projeto.imdb.teste.testeImdb.entity.Filme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    @Query("select new  com.projeto.imdb.teste.testeImdb.entity.Filme(u.nomeFilme,u.genero,u.descFilme,u.id ,sum(e.notaVoto),avg(e.notaVoto))" +
            " from Filme as u LEFT join u.voto e\n" +
            "WHERE  u.nomeFilme =?1 group by u.descDiretor,e.notaVoto  ORDER BY  u.descDiretor asc ")
    Page<Filme> listaFilmeFiltro(String nomeFilme, Pageable pageable);

    @Query("SELECT U FROM Filme  AS U WHERE U.id =?1")
    Filme retornaFilmeSelecionado(Long id);
}
