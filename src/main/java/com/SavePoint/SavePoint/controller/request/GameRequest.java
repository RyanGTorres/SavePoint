package com.SavePoint.SavePoint.controller.request;

import com.SavePoint.SavePoint.enums.Platform;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record GameRequest(
                            @NotEmpty(message = "o titulo do jogo é obrigatorio")
                            String title,
                          String description,
                            @NotEmpty(message = "A data de lançamento do jogo é obrigatorio")
                          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                          LocalDate releaseDate,
                          String developer,
                          Platform plataform,
                          List<Long> categories,
                          List<Long> reviews) {
}
