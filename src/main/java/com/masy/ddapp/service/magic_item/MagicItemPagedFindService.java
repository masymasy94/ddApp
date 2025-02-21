package com.masy.ddapp.service.magic_item;

import com.masy.ddapp.data.dto.MagicItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface MagicItemPagedFindService {
    Page<MagicItemDto> pagedFind(PageRequest pageRequest);
}
