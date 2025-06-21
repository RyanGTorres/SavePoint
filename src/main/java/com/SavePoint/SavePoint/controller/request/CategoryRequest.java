package com.SavePoint.SavePoint.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(
        @Schema(type = "string",description = "Genero do jogo")
        @NotEmpty(message = "Nome do genero é obrigatorio") String gender) {
}
