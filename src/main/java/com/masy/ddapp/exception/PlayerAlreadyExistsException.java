package com.masy.ddapp.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerAlreadyExistsException extends RuntimeException {
    private final String playerName;
}
