package com.projeto.imdb.teste.testeImdb.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_VOTO")
@Getter
@Setter
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long notaVoto;

    @OneToOne
    private Filme filme;

    @OneToOne
    private Usuario usuario;






}
