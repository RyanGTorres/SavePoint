package com.SavePoint.SavePoint.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserRequest(
                            @Schema(type = "string",description = "Nome do Usuario")
                            String nickname,
                            @Schema(type = "string",description = "Email do Usuario")
                              String email,
                            @Schema(type = "string",description = "Senha do Usuario")
                              String password) {
}
