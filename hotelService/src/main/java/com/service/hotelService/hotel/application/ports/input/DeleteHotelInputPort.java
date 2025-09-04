package com.service.hotelService.hotel.application.ports.input;

import java.util.UUID;

public interface DeleteHotelInputPort {
    void delete(UUID id);
}
