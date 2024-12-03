package com.masy.ddapp.service;

import com.masy.ddapp.data.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    List<PlayerDto> findAll();

    String savePlayer(PlayerDto dto);
}
