package com.masy.ddapp.service.magic_item.impl;

import com.masy.ddapp.data.dto.MagicItemDto;
import com.masy.ddapp.data.model.MagicItem;
import com.masy.ddapp.exception.NotFoundException;
import com.masy.ddapp.repository.MagicItemRepository;
import com.masy.ddapp.service.magic_item.MagicItemPutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MagicItemPutServiceImpl implements MagicItemPutService {

    private final MagicItemRepository magicItemRepository;

    @Override
    public void updateMagicItem(String name, MagicItemDto dto) {

        magicItemRepository.findById(name).ifPresentOrElse(
                mItem -> updateFields(mItem, dto),
                () -> {throw new NotFoundException();}
        );
    }

    public void updateFields(MagicItem mItem, MagicItemDto dto){
        mItem.setDescription(dto.description());
        mItem.setRarity(dto.rarity());
        mItem.setAttunement(dto.attunement());
        mItem.setType(dto.type());
        mItem.setPlayerCreator(dto.playerCreator());
    }
}
