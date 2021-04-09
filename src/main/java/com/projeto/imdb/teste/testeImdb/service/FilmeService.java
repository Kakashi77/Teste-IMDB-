package com.projeto.imdb.teste.testeImdb.service;

import com.projeto.imdb.teste.testeImdb.dto.FilmeDTO;
import com.projeto.imdb.teste.testeImdb.entity.Filme;
import org.springframework.data.domain.Page;


public interface FilmeService {
    Filme cadastrarFilme(FilmeDTO filmeDTO);
    Page<FilmeDTO> listarFilmesPorFiltro(String filtro, int pagina, int totalPorPaginas);

}
