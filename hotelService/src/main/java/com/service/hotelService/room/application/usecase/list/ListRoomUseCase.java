package com.service.hotelService.room.application.usecase.list;

import com.service.hotelService.common.application.annotations.UseCase;
import com.service.hotelService.room.application.ports.input.ListRoomInputPort;
import com.service.hotelService.room.application.ports.output.FindAllRoomsOutputPort;
import com.service.hotelService.room.domain.model.RoomDomainEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListRoomUseCase implements ListRoomInputPort {

    private final FindAllRoomsOutputPort findAllRoomsOutputPort;

    @Override
    public List<RoomDomainEntity> listAll() {
        return findAllRoomsOutputPort.findAll();
    }
}
