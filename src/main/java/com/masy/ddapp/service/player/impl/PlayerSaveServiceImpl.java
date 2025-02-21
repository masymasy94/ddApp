package com.masy.ddapp.service.player.impl;

import com.masy.ddapp.data.dto.PlayerDto;
import com.masy.ddapp.exception.PlayerAlreadyExistsException;
import com.masy.ddapp.mapper.PlayerMapper;
import com.masy.ddapp.repository.PlayerRepository;
import com.masy.ddapp.service.player.PlayerSaveService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayerSaveServiceImpl implements PlayerSaveService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public String savePlayer(PlayerDto dto) {

        if (playerRepository.existsById(dto.name())) {
            throw new PlayerAlreadyExistsException(dto.name());
        }

        var entity = playerRepository.save(playerMapper.mapToEntity(dto));
        return entity.getName();
    }
}
