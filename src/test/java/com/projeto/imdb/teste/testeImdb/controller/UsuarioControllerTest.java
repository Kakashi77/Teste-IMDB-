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
class UsuarioControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Test
    public void testListarUsuariosNaoAdmAtivo() throws Exception {
        URI uri = new URI("/usuario/listarUsuariosNaoAdmAtivo");

        mockMvc.perform(MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].senha").isNotEmpty());

    }

    @Test
    public void testCadastrarUsuario() throws Exception {
        URI uri = new URI("/usuario/cadastrarUsuario");
        String json = "{\"email\":\"aluno@email.com\",\"senha\":\"123456\"}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(201));

    }

    @Test
    public void testExcluirUsuario() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/usuario/excluir/{id}","1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(201));
    }

}
