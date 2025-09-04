package com.service.hotelService.room.application.usecase.delete;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.room.application.ports.input.DeleteRoomInputPort;
import com.service.hotelService.room.application.ports.output.DeleteRoomOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
public class DeleteRoomUseCase implements DeleteRoomInputPort {

    private final DeleteRoomOutputPort deleteRoomOutputPort;

    @Override
    public void delete(UUID id) {
        deleteRoomOutputPort.delete(id);
    }
}
