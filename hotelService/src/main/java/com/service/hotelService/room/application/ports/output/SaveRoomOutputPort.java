package com.service.hotelService.room.application.ports.output;

import com.service.hotelService.room.domain.model.RoomDomainEntity;

public interface SaveRoomOutputPort {
    RoomDomainEntity save(RoomDomainEntity room);
}
