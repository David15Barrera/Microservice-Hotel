package com.service.hotelService.hotel.application.usecase.delete;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.hotel.application.ports.input.DeleteHotelInputPort;
import com.service.hotelService.hotel.application.ports.output.DeleteHotelOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class DeleteHotelUseCase implements DeleteHotelInputPort {

    private final DeleteHotelOutputPort deleteHotelOutputPort;

    @Override
    public void delete(UUID id) {
        deleteHotelOutputPort.delete(id);
    }
}
