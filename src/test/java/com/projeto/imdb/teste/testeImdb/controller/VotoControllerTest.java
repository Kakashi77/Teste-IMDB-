package com.projeto.imdb.teste.testeImdb.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
 class VotoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testListarUsuariosNaoAdmAtivo() throws Exception {
        URI uri = new URI("/voto/cadastrarVoto");
        String json = "{\"qtd\":\"1\",\"nataVoto\":\"123456\",\"notaVoto\":\"2\",\"idFilme\":\"1\",\"idUsuario\":\"1\"}";
       // String json = "{\"email\":\"aluno@email.com\",\"senha\":\"123456\"}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(201))
                .andExpect(MockMvcResultMatchers.jsonPath("$.notaVoto").isNotEmpty());

    }
}
