package com.service.hotelService.room.application.ports.input;

import java.util.UUID;

public interface DeleteRoomInputPort {
    void delete(UUID id);
}
