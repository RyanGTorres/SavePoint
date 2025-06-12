package com.SavePoint.SavePoint.controller.request;

import com.SavePoint.SavePoint.enums.Platform;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record GameRequest(String title,
                          String description,
                          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                          LocalDate releaseDate,
                          String developer,
                          Platform plataform,
                          List<Long> categories,
                          List<Long> reviews) {
}
