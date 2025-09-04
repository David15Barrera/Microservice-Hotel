package com.service.hotelService.room.application.ports.output;

import com.service.hotelService.room.domain.model.RoomDomainEntity;

import java.util.List;

public interface FindAllRoomsOutputPort {
    List<RoomDomainEntity> findAll();
}
