package com.masy.ddapp.data.dto;

import com.masy.ddapp.enums.PlayerType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PlayerDto(@NotNull @NotEmpty String name, PlayerType type) {
}
