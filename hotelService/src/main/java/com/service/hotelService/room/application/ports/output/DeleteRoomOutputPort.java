package com.service.hotelService.room.application.ports.output;

import java.util.UUID;

public interface DeleteRoomOutputPort {
    void delete(UUID id);
}
