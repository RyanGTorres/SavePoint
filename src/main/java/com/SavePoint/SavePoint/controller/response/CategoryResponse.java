package com.SavePoint.SavePoint.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CategoryResponse(
                @Schema(type = "long",description = "Codigo do genero")
                Long id,
                @Schema(type = "string",description = "Genero do jogo")
                String gender
) {
}
