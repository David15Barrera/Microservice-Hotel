
package com.service.hotelService.reservation.application.ports.input;

import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;

public interface CreateReservationInputPort {
    ReservationDomainEntity create(ReservationDomainEntity reservation);
}
