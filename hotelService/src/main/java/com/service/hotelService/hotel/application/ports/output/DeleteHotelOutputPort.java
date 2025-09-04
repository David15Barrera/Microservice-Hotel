package com.service.hotelService.hotel.application.ports.output;

import java.util.UUID;

public interface DeleteHotelOutputPort {
    void delete(UUID id);
}
