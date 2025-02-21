package com.masy.ddapp.service.magic_item.impl;

import com.masy.ddapp.exception.NotFoundException;
import com.masy.ddapp.repository.MagicItemRepository;
import com.masy.ddapp.service.magic_item.MagicItemDeleteService;
import com.masy.ddapp.service.player.PlayerDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MagicItemDeleteServiceImpl implements MagicItemDeleteService {

    private final MagicItemRepository magicItemRepository;

    @Override
    public void deleteMagicItem(String name) {
        magicItemRepository.findById(name).ifPresentOrElse(
                        magicItemRepository::delete,
                        () -> {throw new NotFoundException();}
                );
    }
}
