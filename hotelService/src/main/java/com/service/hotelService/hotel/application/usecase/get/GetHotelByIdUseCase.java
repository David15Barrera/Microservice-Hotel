package com.service.hotelService.hotel.application.usecase.get;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.hotel.application.factory.HotelFactory;
import com.service.hotelService.hotel.application.ports.input.GetHotelByIdInputPort;
import com.service.hotelService.hotel.application.ports.output.FindHotelByIdOutputPort;
import com.service.hotelService.hotel.domain.model.HotelDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class GetHotelByIdUseCase implements GetHotelByIdInputPort {

    private final FindHotelByIdOutputPort findHotelByIdOutputPort;
    private final HotelFactory hotelFactory;

    @Override
    public HotelDomainEntity getById(UUID id) {
        HotelDomainEntity h = findHotelByIdOutputPort.findById(id);
        return hotelFactory.createHotelWithRoomCount(h);
    }
}
