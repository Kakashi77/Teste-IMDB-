package com.projeto.imdb.teste.testeImdb.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FilmeDTO {

    @NotNull @NotEmpty
    private String nomeFilme;

    @NotNull @NotEmpty
    private String descFilme;

    @NotNull @NotEmpty
    private String genero;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @NotNull
    private LocalDateTime dataLancamento;

    private Boolean bolAtivo;

    private String descDiretor;

    private List<String> atores;

    private Double media;

    private Long qtdFilmeVotado;

}
