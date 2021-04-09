package com.projeto.imdb.teste.testeImdb.controller;

import com.projeto.imdb.teste.testeImdb.dto.VotoDTO;
import com.projeto.imdb.teste.testeImdb.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@Controller
@RequestMapping(value = "/voto")
public class VotoController {

    @Autowired
    VotoService votoService;

    @PostMapping("/cadastrarVoto")
    public ResponseEntity<VotoDTO> cadastrarVoto(@RequestBody VotoDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/cadastrarJogo").buildAndExpand().toUri();
        VotoDTO votoDto = votoService.cadastrarVoto(dto);
        return ResponseEntity.created(uri).body(votoDto);
    }


}
