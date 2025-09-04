
package com.service.hotelService.reservation.application.ports.output;

import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;

import java.util.UUID;

public interface UpdateReservationOutputPort {
    ReservationDomainEntity update(UUID id, ReservationDomainEntity reservation);
}
