package com.masy.ddapp.service.player.impl;

import com.masy.ddapp.repository.PlayerRepository;
import com.masy.ddapp.service.player.PlayerDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class PlayerDeleteServiceImpl implements PlayerDeleteService {

    private final PlayerRepository playerRepository;

    @Override
    public void deletePlayer(String name) {
        playerRepository.deleteById(name);
    }
}
