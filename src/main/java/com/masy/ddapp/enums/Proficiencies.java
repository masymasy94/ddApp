package com.masy.ddapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.masy.ddapp.enums.Modifier.*;

@Getter
@AllArgsConstructor
public enum Proficiencies {

    ACROBATICS(DEX),
    ANIMAL_HANDLING(WIS),
    ARCANA(INT),
    ATHLETICS(STR),
    DECEPTION(CHA),
    HISTORY(INT),
    INSIGHT(WIS),
    INTIMIDATION(CHA),
    INVESTIGATION(INT),
    MEDICINE(WIS),
    NATURE(INT),
    PERCEPTION(WIS),
    PERFORMANCE(CHA),
    PERSUASION(CHA),
    RELIGION(INT),
    SLEIGHT_OF_HAND(DEX),
    STEALTH(DEX),
    SURVIVAL(WIS);

    private final Modifier modifier;
}
