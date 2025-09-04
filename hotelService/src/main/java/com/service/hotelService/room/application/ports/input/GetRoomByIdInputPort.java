package com.service.hotelService.room.application.ports.input;

import com.service.hotelService.room.domain.model.RoomDomainEntity;

import java.util.UUID;

public interface GetRoomByIdInputPort {
    RoomDomainEntity getById(UUID id);
}
