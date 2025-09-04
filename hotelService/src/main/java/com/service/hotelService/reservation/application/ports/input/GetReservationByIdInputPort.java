
package com.service.hotelService.reservation.application.ports.input;

import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;

import java.util.UUID;

public interface GetReservationByIdInputPort {
    ReservationDomainEntity getById(UUID id);
}
