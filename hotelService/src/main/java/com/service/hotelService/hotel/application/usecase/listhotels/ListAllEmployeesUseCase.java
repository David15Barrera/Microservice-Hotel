package com.service.hotelService.hotel.application.usecase.listhotels;


import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.hotel.application.factory.HotelFactory;
import com.service.hotelService.hotel.application.ports.input.ListAllHotelInputPort;
import com.service.hotelService.hotel.application.ports.output.FindingAllHotelsOutputPort;
import com.service.hotelService.hotel.domain.model.HotelDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListAllEmployeesUseCase implements ListAllHotelInputPort {

    private final HotelFactory factory;
    private final FindingAllHotelsOutputPort  findingAllHotelsOutputPort;

    @Override
    public List<HotelDomainEntity> ListAllHotel() {
        return findingAllHotelsOutputPort.findAllHotels().stream()
                .map(factory::createHotelWithRoomCount)
                .toList();
    }
}
