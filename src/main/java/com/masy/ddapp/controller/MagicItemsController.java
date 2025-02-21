package com.masy.ddapp.controller;


import com.masy.ddapp.data.dto.MagicItemDto;
import com.masy.ddapp.service.magic_item.MagicItemDeleteService;
import com.masy.ddapp.service.magic_item.MagicItemPagedFindService;
import com.masy.ddapp.service.magic_item.MagicItemPutService;
import com.masy.ddapp.service.magic_item.MagicItemSaveService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/magic-items", produces = MediaType.APPLICATION_JSON_VALUE)
public class MagicItemsController {

    private final MagicItemPagedFindService magicItemPagedFindService;
    private final MagicItemSaveService magicItemSaveService;
    private final MagicItemDeleteService magicItemDeleteService;
    private final MagicItemPutService magicItemPutService;

    @GetMapping()
    public Page<MagicItemDto> getMagicItemsPaginated(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                        @RequestParam(value = "pageSize", defaultValue = "100") Integer pageSize,
                                                        @RequestParam(value = "sortBy",defaultValue = "name") String sortBy) {
        return magicItemPagedFindService.pagedFind(PageRequest.of(offset, pageSize, Sort.by(sortBy)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertPlayer(@Valid @RequestBody MagicItemDto dto) {

        String name = magicItemSaveService.saveMagicItem(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("location", name)
                .build();
    }

    @DeleteMapping("{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMagicItem(@PathVariable("name") String name) {
        magicItemDeleteService.deleteMagicItem(name);
    }


    @PutMapping(value = "{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMagicItem(@PathVariable String name, @RequestBody @Valid MagicItemDto dto) {
        magicItemPutService.updateMagicItem(name, dto);
    }
}
