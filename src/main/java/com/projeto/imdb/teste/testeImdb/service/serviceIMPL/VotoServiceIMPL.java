package com.projeto.imdb.teste.testeImdb.service.serviceIMPL;

import com.projeto.imdb.teste.testeImdb.dto.VotoDTO;
import com.projeto.imdb.teste.testeImdb.entity.Voto;
import com.projeto.imdb.teste.testeImdb.repository.FilmeRepository;
import com.projeto.imdb.teste.testeImdb.repository.UsuarioRepository;
import com.projeto.imdb.teste.testeImdb.repository.VotoRepository;
import com.projeto.imdb.teste.testeImdb.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoServiceIMPL implements VotoService {

    @Autowired
    VotoRepository votoRepository;

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public VotoDTO cadastrarVoto(VotoDTO votoDTO) {
        Voto voto = converterVotoDtoParaVoto(votoDTO);
        votoRepository.save(voto);
        return converterVotoParaVotoDto(voto);
    }


    private Voto converterVotoDtoParaVoto(VotoDTO dto){
        Voto voto = new Voto();

        voto.setFilme(filmeRepository.retornaFilmeSelecionado(dto.getIdFilme()));
        voto.setUsuario(usuarioRepository.retornaUsuarioSelecionado(dto.getIdUsuario()));
        voto.setNotaVoto(dto.getNotaVoto());
        return voto;
    }


    private VotoDTO converterVotoParaVotoDto(Voto voto){
        VotoDTO dto = new VotoDTO();

        dto.setId(voto.getFilme().getId() );
        dto.setNotaVoto(voto.getNotaVoto());
        dto.setIdFilme(voto.getFilme().getId());
        dto.setIdUsuario(voto.getUsuario().getId());
        return dto;
    }
}
