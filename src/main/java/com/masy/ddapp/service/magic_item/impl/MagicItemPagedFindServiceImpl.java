package com.masy.ddapp.service.magic_item.impl;

import com.masy.ddapp.data.dto.MagicItemDto;
import com.masy.ddapp.mapper.MagicItemMapper;
import com.masy.ddapp.repository.MagicItemRepository;
import com.masy.ddapp.service.magic_item.MagicItemPagedFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MagicItemPagedFindServiceImpl implements MagicItemPagedFindService {

    private final MagicItemRepository magicItemRepository;
    private final MagicItemMapper magicItemMapper;


    @Override
    public Page<MagicItemDto> pagedFind(PageRequest pageRequest) {

        return magicItemRepository.findAll(pageRequest).map(magicItemMapper::mapToDto);
    }
}
