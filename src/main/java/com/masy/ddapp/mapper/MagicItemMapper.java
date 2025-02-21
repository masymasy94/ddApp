package com.masy.ddapp.mapper;

import com.masy.ddapp.data.dto.MagicItemDto;
import com.masy.ddapp.data.model.MagicItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;


@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MagicItemMapper {

    MagicItem mapToEntity(MagicItemDto dto);
    MagicItemDto mapToDto(MagicItem entity);
}