package com.SavePoint.SavePoint.controller.response;


import com.SavePoint.SavePoint.entity.Game;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ReviewResponse(Long id,
                             String title,
                             String content,
                             double rating,
                             LocalDate date,
                             Game game)

{
}
