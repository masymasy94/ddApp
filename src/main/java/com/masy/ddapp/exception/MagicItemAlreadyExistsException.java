package com.masy.ddapp.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MagicItemAlreadyExistsException extends RuntimeException {
    private final String mItemName;
}
