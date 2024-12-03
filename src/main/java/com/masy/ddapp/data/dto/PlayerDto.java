package com.masy.ddapp.data.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PlayerDto(@NotNull @NotEmpty String name, boolean master) {
}
