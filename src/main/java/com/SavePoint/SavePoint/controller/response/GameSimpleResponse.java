package com.SavePoint.SavePoint.controller.response;

import lombok.Builder;

@Builder
public record GameSimpleResponse(Long id,
                                 String title)
{
}
