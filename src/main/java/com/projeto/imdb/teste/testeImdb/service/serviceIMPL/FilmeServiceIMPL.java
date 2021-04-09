package com.projeto.imdb.teste.testeImdb.service.serviceIMPL;

import com.projeto.imdb.teste.testeImdb.dto.FilmeDTO;
import com.projeto.imdb.teste.testeImdb.entity.Filme;
import com.projeto.imdb.teste.testeImdb.entity.Perfil;
import com.projeto.imdb.teste.testeImdb.repository.FilmeRepository;
import com.projeto.imdb.teste.testeImdb.repository.UsuarioRepository;
import com.projeto.imdb.teste.testeImdb.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class FilmeServiceIMPL implements FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Filme cadastrarFilme(FilmeDTO filmeDTO) {
        Filme filme = converterFilmeDtoParaFilme(filmeDTO);
        return filmeRepository.save(filme);
    }

    @Override
    public Page<FilmeDTO> listarFilmesPorFiltro(String filtro, int pagina, int totalPorPagina) {
        Pageable pag = PageRequest.of(pagina, totalPorPagina);
        Page<Filme> listFilme = filmeRepository.listaFilmeFiltro(filtro, pag);

        return listFilme.map(result -> converterFilmeParaFilmeDTO(result));
    }


    private Filme converterFilmeDtoParaFilme(FilmeDTO filmeDTO) {
        Filme filme = new Filme();

        filme.setNomeFilme(filmeDTO.getNomeFilme());
        filme.setDataLacamento(filmeDTO.getDataLancamento());
        filme.setDescFilme(filmeDTO.getDescFilme());
        filme.setGenero(filmeDTO.getGenero());
        filme.setDescDiretor(filmeDTO.getDescDiretor());

        return filme;
    }

    private FilmeDTO converterFilmeParaFilmeDTO(Filme filme) {
        FilmeDTO dto = new FilmeDTO();
        dto.setNomeFilme(filme.getNomeFilme());
        dto.setDataLancamento(filme.getDataLacamento());
        dto.setDescFilme(filme.getDescFilme());
        dto.setGenero(filme.getGenero());
        dto.setDescDiretor(filme.getDescDiretor());
        dto.setMedia(filme.getMedia());
        dto.setQtdFilmeVotado(filme.getQtdFilmeVotado());

        return dto;
    }
}
