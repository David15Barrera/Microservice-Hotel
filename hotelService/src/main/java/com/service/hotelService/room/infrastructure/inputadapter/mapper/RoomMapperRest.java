package com.service.hotelService.room.infrastructure.inputadapter.mapper;

import com.service.hotelService.room.domain.model.RoomDomainEntity;
import com.service.hotelService.room.infrastructure.inputadapter.dto.RoomRequestDto;
import com.service.hotelService.room.infrastructure.inputadapter.dto.RoomResponseDto;

public class RoomMapperRest {

    public static RoomDomainEntity toDomain(RoomRequestDto dto) {
        if (dto == null) return null;
        return RoomDomainEntity.builder()
                .hotelId(dto.getHotelId())
                .roomNumber(dto.getRoomNumber())
                .pricePerDay(dto.getPricePerDay())
                .maintenanceCostPerDay(dto.getMaintenanceCostPerDay())
                .description(dto.getDescription())
                .capacity(dto.getCapacity())
                .state(dto.getState())
                .build();
    }

    public static RoomResponseDto toResponse(RoomDomainEntity d) {
        if (d == null) return null;
        return RoomResponseDto.builder()
                .id(d.getId())
                .hotelId(d.getHotelId())
                .roomNumber(d.getRoomNumber())
                .pricePerDay(d.getPricePerDay())
                .maintenanceCostPerDay(d.getMaintenanceCostPerDay())
                .description(d.getDescription())
                .capacity(d.getCapacity())
                .state(d.getState())
                .build();
    }
}
