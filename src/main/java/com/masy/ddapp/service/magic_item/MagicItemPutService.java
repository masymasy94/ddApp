package com.masy.ddapp.service.magic_item;

import com.masy.ddapp.data.dto.MagicItemDto;

public interface MagicItemPutService {
    void updateMagicItem(String name, MagicItemDto dto);
}
