
package com.service.hotelService.reservation.application.ports.output;

import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindReservationsByRoomOutputPort {
    List<ReservationDomainEntity> findByRoom(UUID roomId);
}
