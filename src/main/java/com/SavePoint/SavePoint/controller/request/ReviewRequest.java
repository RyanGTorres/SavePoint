package com.SavePoint.SavePoint.controller.request;


import java.time.LocalDate;

public record ReviewRequest (String title,
                             String content,
                             double rating,
                             LocalDate date,
                             Long gameId
) {}
