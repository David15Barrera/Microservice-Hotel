package com.service.hotelService.room.infrastructure.persistence.mapper;

import com.service.hotelService.room.domain.model.RoomDomainEntity;
import com.service.hotelService.room.infrastructure.persistence.entity.RoomDBEntity;

public class RoomMapper {

    public static RoomDBEntity toDB(RoomDomainEntity d) {
        if (d == null) return null;
        RoomDBEntity e = new RoomDBEntity();

        if (d.getId() != null) {
            e.setId(d.getId());
        }
        e.setRoomNumber(d.getRoomNumber());
        e.setPricePerDay(d.getPricePerDay());
        e.setCostMaintenancePerDay(d.getMaintenanceCostPerDay());
        e.setDescription(d.getDescription());
        e.setCapacity(d.getCapacity());
        e.setState(d.getState());
        // hotel lo asigna el adapter, no aquí
        return e;
    }


    public static RoomDomainEntity toDomain(RoomDBEntity e) {
        if (e == null) return null;
        return RoomDomainEntity.builder()
                .id(e.getId())
                .hotelId(e.getHotel() == null ? null : e.getHotel().getId())
                .roomNumber(e.getRoomNumber())
                .pricePerDay(e.getPricePerDay())
                .maintenanceCostPerDay(e.getCostMaintenancePerDay())
                .description(e.getDescription())
                .capacity(e.getCapacity())
                .state(e.getState())
                .build();
    }
}
