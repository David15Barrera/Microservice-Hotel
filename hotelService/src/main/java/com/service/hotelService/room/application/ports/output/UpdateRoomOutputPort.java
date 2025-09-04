package com.service.hotelService.room.application.ports.output;

import com.service.hotelService.room.domain.model.RoomDomainEntity;

import java.util.UUID;

public interface UpdateRoomOutputPort {
    RoomDomainEntity update(UUID id, RoomDomainEntity room);
}
