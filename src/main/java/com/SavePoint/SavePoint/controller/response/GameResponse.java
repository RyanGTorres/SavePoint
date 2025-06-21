package com.SavePoint.SavePoint.controller.response;

import java.util.List;
import com.SavePoint.SavePoint.enums.Platform;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record GameResponse(@Schema(type = "long",description = "codigo do jogo")
                           Long id,
                           @Schema(type = "string",description = "Titulo do jogo")
                           String title,
                           @Schema(type = "string",description = "Descrição do jogo")
                           String description,
                           @Schema(type = "date",description = "Data de lançamento do jogo")
                           LocalDate releaseDate,
                           @Schema(type = "string",description = "Desenvolvedora do jogo")
                           String developer,
                           @Schema(type = "enum",description = "Plataforma do jogo")
                           Platform plataform,
                           @Schema(type = "array",description = "Lista de codigo de categorias")
                           List<CategoryResponse> categories,
                           @Schema(type = "array",description = "Lista de codigo de reviews")
                           List<ReviewResponse> reviews
                           ){
}
