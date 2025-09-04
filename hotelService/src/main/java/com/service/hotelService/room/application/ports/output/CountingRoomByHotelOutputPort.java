package com.service.hotelService.room.application.ports.output;


import java.util.UUID;

public interface CountingRoomByHotelOutputPort {
    int countRoomByHotel(UUID hotelId);
}
