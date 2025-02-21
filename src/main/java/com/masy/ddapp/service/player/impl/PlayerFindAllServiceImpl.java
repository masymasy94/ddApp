package com.masy.ddapp.service.player.impl;

import com.masy.ddapp.data.dto.PlayerDto;
import com.masy.ddapp.mapper.PlayerMapper;
import com.masy.ddapp.repository.PlayerRepository;
import com.masy.ddapp.service.player.PlayerFindAllService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlayerFindAllServiceImpl implements PlayerFindAllService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PlayerDto> findAll() {
        return playerRepository.findAll().stream().map(playerMapper::mapToDto).toList();
    }

}
