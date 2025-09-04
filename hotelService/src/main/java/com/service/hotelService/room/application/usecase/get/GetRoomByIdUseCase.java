package com.service.hotelService.room.application.usecase.get;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.room.application.ports.input.GetRoomByIdInputPort;
import com.service.hotelService.room.application.ports.output.FindRoomByIdOutputPort;
import com.service.hotelService.room.domain.model.RoomDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class GetRoomByIdUseCase implements GetRoomByIdInputPort {

    private final FindRoomByIdOutputPort findRoomByIdOutputPort;

    @Override
    public RoomDomainEntity getById(UUID id) {
        return findRoomByIdOutputPort.findById(id);
    }
}
