package com.service.hotelService.hotel.application.ports.input;

import com.service.hotelService.hotel.domain.model.HotelDomainEntity;

public interface CreateHotelInputPort {
    HotelDomainEntity create(HotelDomainEntity hotel);
}
