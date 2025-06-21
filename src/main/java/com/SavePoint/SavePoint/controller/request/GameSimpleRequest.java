package com.SavePoint.SavePoint.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record GameSimpleRequest(
        @Schema(type = "long",description = "Codigo do jogo simplicado para genero")
        Long id){
}
