package com.projeto.imdb.teste.testeImdb.controller;

import com.projeto.imdb.teste.testeImdb.dto.FilmeDTO;
import com.projeto.imdb.teste.testeImdb.entity.Filme;
import com.projeto.imdb.teste.testeImdb.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Controller
@RestController
@RequestMapping(value = "/filme")
public class FilmeController {

    @Autowired
    FilmeService filmeService;


    @PostMapping("/cadastrarFilme")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody @Valid FilmeDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/inserirJogo").buildAndExpand().toUri();
        Filme filme = filmeService.cadastrarFilme(dto);
        return ResponseEntity.created(uri).body(filme);
    }

    @GetMapping("/listarFilmes/{filtro}/{pagina}")
    public ResponseEntity<Page<FilmeDTO>> retornaListaFilme(@PathVariable String filtro, @PathVariable Integer pagina, Integer totalPorPagina) {
        return ResponseEntity.ok().body(filmeService.listarFilmesPorFiltro(filtro, pagina, totalPorPagina));
    }

}
