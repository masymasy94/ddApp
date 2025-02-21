package com.masy.ddapp.service.magic_item.impl;

import com.masy.ddapp.data.dto.MagicItemDto;
import com.masy.ddapp.mapper.MagicItemMapper;
import com.masy.ddapp.repository.MagicItemsRepository;
import com.masy.ddapp.service.magic_item.MagicItemsPagedFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MagicItemsPagedFindServiceImpl implements MagicItemsPagedFindService {

    private final MagicItemsRepository magicItemsRepository;
    private final MagicItemMapper magicItemMapper;


    @Override
    public Page<MagicItemDto> pagedFind(PageRequest pageRequest) {

        return magicItemsRepository.findAll(pageRequest).map(magicItemMapper::mapToDto);
    }
}
