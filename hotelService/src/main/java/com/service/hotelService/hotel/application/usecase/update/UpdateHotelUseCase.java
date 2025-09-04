package com.service.hotelService.hotel.application.usecase.update;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.hotel.application.factory.HotelFactory;
import com.service.hotelService.hotel.application.ports.input.UpdateHotelInputPort;
import com.service.hotelService.hotel.application.ports.output.UpdateHotelOutputPort;
import com.service.hotelService.hotel.domain.model.HotelDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class UpdateHotelUseCase implements UpdateHotelInputPort {

    private final UpdateHotelOutputPort updateHotelOutputPort;
    private final HotelFactory hotelFactory;

    @Override
    public HotelDomainEntity update(UUID id, HotelDomainEntity hotel) {
        HotelDomainEntity updated = updateHotelOutputPort.update(id, hotel);
        return hotelFactory.createHotelWithRoomCount(updated);
    }
}
