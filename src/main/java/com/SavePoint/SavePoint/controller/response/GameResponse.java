package com.SavePoint.SavePoint.controller.response;

import java.util.List;
import com.SavePoint.SavePoint.enums.Platform;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record GameResponse(Long id,
                           String title,
                           String description,
                           LocalDate releaseDate,
                           String developer,
                           Platform plataform,
                           List<CategoryResponse> categories,
                           List<ReviewResponse> reviews
                           ){
}
