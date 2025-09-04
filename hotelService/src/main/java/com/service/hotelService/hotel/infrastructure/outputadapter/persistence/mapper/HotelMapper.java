package com.service.hotelService.hotel.infrastructure.outputadapter.persistence.mapper;

import com.service.hotelService.hotel.domain.model.HotelDomainEntity;
import com.service.hotelService.hotel.infrastructure.outputadapter.persistence.entity.HotelDBEntity;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public HotelDomainEntity toDomain(HotelDBEntity hotelDBEntity) {
        if (hotelDBEntity == null) {
            return null;
        }
        return new HotelDomainEntity(
                hotelDBEntity.getId(),
                hotelDBEntity.getName(),
                hotelDBEntity.getAddress(),
                hotelDBEntity.getPhone(),
                0 // este "0" podrías mapearlo si tu dominio lleva otro campo
        );
    }

    public HotelDBEntity toDB(HotelDomainEntity d) {
        if (d == null) return null;
        HotelDBEntity e = new HotelDBEntity();
        if (d.getId() != null) e.setId(d.getId());
        e.setName(d.getName());
        e.setAddress(d.getAddress());
        e.setPhone(d.getPhone());
        return e;
    }
}
