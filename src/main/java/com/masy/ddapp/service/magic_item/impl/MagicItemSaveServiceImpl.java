package com.masy.ddapp.service.magic_item.impl;

import com.masy.ddapp.data.dto.MagicItemDto;
import com.masy.ddapp.exception.MagicItemAlreadyExistsException;
import com.masy.ddapp.exception.PlayerAlreadyExistsException;
import com.masy.ddapp.mapper.MagicItemMapper;
import com.masy.ddapp.repository.MagicItemRepository;
import com.masy.ddapp.service.magic_item.MagicItemSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MagicItemSaveServiceImpl implements MagicItemSaveService {

    public final MagicItemRepository magicItemRepository;
    public final MagicItemMapper magicItemMapper;

    @Override
    public String saveMagicItem(MagicItemDto dto) {

        if (magicItemRepository.existsById(dto.name())) {
            throw new MagicItemAlreadyExistsException(dto.name());
        }

        var entity = magicItemRepository.save(magicItemMapper.mapToEntity(dto));
        return entity.getName();
    }





}
