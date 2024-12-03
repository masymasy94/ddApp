package com.masy.ddapp.mapper;


import com.masy.ddapp.data.dto.PlayerDto;
import com.masy.ddapp.data.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PlayerMapper {

    Player mapToEntity(PlayerDto dto);
    PlayerDto mapToDto(Player entity);
}
