package com.SavePoint.SavePoint.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(
        @Schema(type = "string",description = "Email do usuario")
        String email,
        @Schema(type = "string",description = "Senha do usuario")
        String password) {

}
