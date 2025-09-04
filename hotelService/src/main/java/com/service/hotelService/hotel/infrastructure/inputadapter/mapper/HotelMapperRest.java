package com.service.hotelService.hotel.infrastructure.inputadapter.mapper;

import com.service.hotelService.hotel.domain.model.HotelDomainEntity;
import com.service.hotelService.hotel.infrastructure.inputadapter.dto.HotelRequestDto;
import com.service.hotelService.hotel.infrastructure.inputadapter.dto.HotelResponseDto;
import org.springframework.stereotype.Component;

@Component
public class HotelMapperRest {

    public HotelResponseDto toResponseDto(HotelDomainEntity hotelDomainEntity) {
        if (hotelDomainEntity == null) return null;

        return new HotelResponseDto(
                hotelDomainEntity.getId(),
                hotelDomainEntity.getName(),
                hotelDomainEntity.getAddress(),
                hotelDomainEntity.getPhone(),
                hotelDomainEntity.getTotalRoom()
        );
    }

    public HotelDomainEntity toDomain(HotelRequestDto dto) {
        if (dto == null) return null;
        return new HotelDomainEntity(
                dto.getName(),
                dto.getAddress(),
                dto.getPhone(),
                0
        );
    }
}