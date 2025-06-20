package com.SavePoint.SavePoint.configs;

import lombok.Builder;

@Builder
public record JWTUserData(Long id,
                          String email,
                          String nickname) {
}
