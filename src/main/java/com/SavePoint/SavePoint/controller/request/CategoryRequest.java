package com.SavePoint.SavePoint.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(@NotEmpty(message = "Nome do genero é obrigatorio") String gender) {
}
