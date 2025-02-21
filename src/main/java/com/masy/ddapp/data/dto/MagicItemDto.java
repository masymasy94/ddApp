package com.masy.ddapp.data.dto;

import com.masy.ddapp.enums.ItemType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MagicItemDto(@NotNull @NotEmpty String name,
                           @NotNull @NotEmpty String description,
                           @NotNull  String rarity,
                           @NotNull Boolean  attunement,
                           @NotNull String type,
                           @NotNull @NotEmpty String playerCreator
                           )
{}
