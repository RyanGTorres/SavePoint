package com.SavePoint.SavePoint.controller.request;


import com.SavePoint.SavePoint.entity.Game;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ReviewRequest (String title,
                             String content,
                             double rating,
                             LocalDate date,
                             Game game
) {}
