package com.SavePoint.SavePoint.controller.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id,
                           String nickname,
                           String email) {
}
