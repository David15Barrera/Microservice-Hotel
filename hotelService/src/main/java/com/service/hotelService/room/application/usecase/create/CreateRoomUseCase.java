package com.service.hotelService.room.application.usecase.create;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.room.application.ports.input.CreateRoomInputPort;
import com.service.hotelService.room.application.ports.output.SaveRoomOutputPort;
import com.service.hotelService.room.domain.model.RoomDomainEntity;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateRoomUseCase implements CreateRoomInputPort {

    private final SaveRoomOutputPort saveRoomOutputPort;

    @Override
    public RoomDomainEntity create(RoomDomainEntity room) {
        return saveRoomOutputPort.save(room);
    }
}
