package com.service.hotelService.room.application.usecase.update;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.room.application.ports.input.UpdateRoomInputPort;
import com.service.hotelService.room.application.ports.output.UpdateRoomOutputPort;
import com.service.hotelService.room.domain.model.RoomDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class UpdateRoomUseCase implements UpdateRoomInputPort {

    private final UpdateRoomOutputPort updateRoomOutputPort;

    @Override
    public RoomDomainEntity update(UUID id, RoomDomainEntity room) {
        return updateRoomOutputPort.update(id, room);
    }
}
