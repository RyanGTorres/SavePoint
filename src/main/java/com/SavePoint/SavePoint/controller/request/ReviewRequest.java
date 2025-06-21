package com.SavePoint.SavePoint.controller.request;


import com.SavePoint.SavePoint.entity.Game;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ReviewRequest (
                            @Schema(type = "string",description = "Titulo do Avaliação")
                            String title,
                            @Schema(type = "string",description = "Conteudo da Avaliação")
                            String content,
                            @Schema(type = "double",description = "Nota da Avaliação")
                             double rating,
                            @Schema(type = "date",description = "Data de criação da avaliação")
                             LocalDate date,
                            @Schema(type = "array",description = "Entidade do Jogo")
                             Game game
) {}
