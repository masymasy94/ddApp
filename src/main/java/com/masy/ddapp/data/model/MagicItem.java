package com.masy.ddapp.data.model;

import com.masy.ddapp.data.model.converter.BooleanMagicItemsConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "magic_items")
public class MagicItem {

    @Id
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "rarity")
    private String rarity;

    @NotNull
    @Column(name = "attunement")
    @Convert(converter = BooleanMagicItemsConverter.class)
    private Boolean attunement;

    @Column(name = "type")
    private String type;

    @Column(name = "player_creator")
    private String playerCreator;

}
