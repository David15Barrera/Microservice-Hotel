package com.service.hotelService.hotel.application.usecase.create;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.hotel.application.factory.HotelFactory;
import com.service.hotelService.hotel.application.ports.input.CreateHotelInputPort;
import com.service.hotelService.hotel.application.ports.output.SaveHotelOutputPort;
import com.service.hotelService.hotel.domain.model.HotelDomainEntity;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateHotelUseCase implements CreateHotelInputPort {

    private final SaveHotelOutputPort saveHotelOutputPort;
    private final HotelFactory hotelFactory;

    @Override
    public HotelDomainEntity create(HotelDomainEntity hotel) {
        HotelDomainEntity saved = saveHotelOutputPort.save(hotel);
        return hotelFactory.createHotelWithRoomCount(saved);
    }
}
