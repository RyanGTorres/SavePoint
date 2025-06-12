package com.SavePoint.SavePoint.controller.response;

import lombok.Builder;

@Builder
public record CategoryResponse(
                Long id,
                String gender
) {
}
