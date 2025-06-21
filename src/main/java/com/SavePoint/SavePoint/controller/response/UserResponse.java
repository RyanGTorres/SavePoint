package com.SavePoint.SavePoint.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserResponse(
        @Schema(type = "string",description = "Nome do Usuario")
        Long id,
        @Schema(type = "string",description = "Email do Usuario")
                           String nickname,
        @Schema(type = "string",description = "Senha do Usuario")
                           String email) {
}
