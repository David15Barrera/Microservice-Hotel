package com.service.hotelService.hotel.application.ports.input;

import com.service.hotelService.hotel.domain.model.HotelDomainEntity;

import java.util.UUID;

public interface UpdateHotelInputPort {
    HotelDomainEntity update(UUID id, HotelDomainEntity hotel);
}
