package com.SavePoint.SavePoint.controller.request;

import com.SavePoint.SavePoint.enums.Platform;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record GameRequest(@Schema(type = "string",description = "Titulo do jogo")
                          @NotEmpty(message = "o titulo do jogo é obrigatorio")
                          String title,
                          @Schema(type = "string",description = "Descrição do jogo")
                          String description,
                          @Schema(type = "date",description = "Data de lançamento do jogo")
                          @NotEmpty(message = "A data de lançamento do jogo é obrigatorio")
                          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                          LocalDate releaseDate,
                          @Schema(type = "string",description = "Desenvolvedora do jogo")
                          String developer,
                          @Schema(type = "enum",description = "Plataforma do jogo")
                          Platform plataform,
                          @Schema(type = "array",description = "Lista de codigo de categorias")
                          List<Long> categories,
                          @Schema(type = "array",description = "Lista de codigo de reviews")
                          List<Long> reviews) {
}
