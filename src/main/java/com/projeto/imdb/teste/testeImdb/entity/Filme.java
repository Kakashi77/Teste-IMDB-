package com.projeto.imdb.teste.testeImdb.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFilme;

    private String descFilme;

    private String descDiretor;

    private Long qtdFilmeVotado;

    private Double media;

    private String genero;

    private LocalDateTime dataLacamento;


    @OneToMany(mappedBy = "filme")
    private List<Voto> voto;

    public Filme(String nomeFilme, String descFilme, String descDiretor, Long id, Long qtdFilmeVotado, Double media) {
        this.nomeFilme = nomeFilme;
        this.descFilme = descFilme;
        this.descDiretor = descDiretor;
        this.id = id;
        this.qtdFilmeVotado = qtdFilmeVotado;
        this.media = media;
    }

    public Filme() {

    }
}
