package com.service.hotelService.hotel.application.ports.output;

import com.service.hotelService.hotel.domain.model.HotelDomainEntity;

public interface SaveHotelOutputPort {
    HotelDomainEntity save(HotelDomainEntity hotel);
}
