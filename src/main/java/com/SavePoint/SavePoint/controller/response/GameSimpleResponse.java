package com.SavePoint.SavePoint.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record GameSimpleResponse(
        @Schema(type = "long",description = "Codigo do Jogo simplificado para genero")
        Long id,
        @Schema(type = "string",description = "Nome do Jogo simplificado para genero")
        String title)
{
}
