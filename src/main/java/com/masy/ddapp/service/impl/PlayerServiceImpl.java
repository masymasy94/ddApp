package com.masy.ddapp.service.impl;

import com.masy.ddapp.data.dto.PlayerDto;
import com.masy.ddapp.exception.PlayerAlreadyExistsException;
import com.masy.ddapp.mapper.PlayerMapper;
import com.masy.ddapp.repository.PlayerRepository;
import com.masy.ddapp.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PlayerDto> findAll() {
        return playerRepository.findAll().stream().map(playerMapper::mapToDto).toList();

    }

    @Override
    public String savePlayer(PlayerDto dto) {

        if (playerRepository.existsById(dto.name())) {
            throw new PlayerAlreadyExistsException(dto.name());
        }

        var entity = playerRepository.save(playerMapper.mapToEntity(dto));
        return entity.getName();
    }

    @Override
    public void deletePlayer(String name) {
        playerRepository.deleteById(name);
    }
}
