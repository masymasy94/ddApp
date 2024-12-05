package com.masy.ddapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Modifier {
    STR("STRENGTH"),
    DEX("DEXTERITY"),
    CON("CONSTITUTION"),
    INT("INTELLIGENCE"),
    WIS("WISDOM"),
    CHA("CHARISMA");


    private final String description;
}
