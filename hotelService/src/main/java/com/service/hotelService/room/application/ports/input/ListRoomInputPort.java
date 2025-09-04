package com.service.hotelService.room.application.ports.input;

import com.service.hotelService.room.domain.model.RoomDomainEntity;

import java.util.List;

public interface ListRoomInputPort {
    List<RoomDomainEntity> listAll();
}
