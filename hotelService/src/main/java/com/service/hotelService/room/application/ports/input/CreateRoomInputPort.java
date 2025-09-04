package com.service.hotelService.room.application.ports.input;

import com.service.hotelService.room.domain.model.RoomDomainEntity;

public interface CreateRoomInputPort {
    RoomDomainEntity create(RoomDomainEntity room);
}
