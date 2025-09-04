package com.service.hotelService.hotel.application.ports.output;

import com.service.hotelService.hotel.domain.model.HotelDomainEntity;

import java.util.UUID;

public interface FindHotelByIdOutputPort {
    HotelDomainEntity findById(UUID id);
}
