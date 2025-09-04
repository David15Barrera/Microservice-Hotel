package com.service.hotelService.hotel.application.ports.output;

import com.service.hotelService.hotel.domain.model.HotelDomainEntity;

import java.util.List;

public interface FindingAllHotelsOutputPort {

    List<HotelDomainEntity> findAllHotels();
}
