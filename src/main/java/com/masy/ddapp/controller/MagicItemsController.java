package com.masy.ddapp.controller;


import com.masy.ddapp.data.dto.MagicItemDto;
import com.masy.ddapp.service.magic_item.MagicItemsPagedFindService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping(value = "magic-items", produces = MediaType.APPLICATION_JSON_VALUE)
public class MagicItemsController {

    private final MagicItemsPagedFindService magicItemsPagedFindService;

    // 200
    @GetMapping()
    public Page<MagicItemDto> getMagicItemsPaginated(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                        @RequestParam(value = "pageSize", defaultValue = "100") Integer pageSize,
                                                        @RequestParam(value = "sortBy",defaultValue = "name") String sortBy) {
        return magicItemsPagedFindService.pagedFind(PageRequest.of(offset, pageSize, Sort.by(sortBy)));
    }
}
