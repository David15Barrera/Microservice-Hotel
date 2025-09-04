package com.service.hotelService.hotel.application.ports.input;

import com.service.hotelService.hotel.domain.model.HotelDomainEntity;

import java.util.List;

public interface ListAllHotelInputPort {
    List<HotelDomainEntity> ListAllHotel();
}
