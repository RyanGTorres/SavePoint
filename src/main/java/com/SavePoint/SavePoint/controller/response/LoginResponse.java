package com.SavePoint.SavePoint.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(
        @Schema(type = "String",description = "Token do JWT")
        String token) {
}
