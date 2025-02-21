package com.masy.ddapp.data.model;

import com.masy.ddapp.enums.PlayerType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column(name = "name")
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PlayerType type;
}
