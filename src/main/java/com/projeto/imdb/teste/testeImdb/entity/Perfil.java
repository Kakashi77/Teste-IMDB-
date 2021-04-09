package com.projeto.imdb.teste.testeImdb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "PERFIL")
@Getter
@Setter
public class Perfil   implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Perfil(String nome, Long id){
        this.nome = nome;
        this.id = id;
    }

    public Perfil(){}


    @Override
    public String getAuthority() {
        return this.nome;
    }
}
