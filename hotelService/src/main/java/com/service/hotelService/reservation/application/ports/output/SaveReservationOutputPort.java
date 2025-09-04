
package com.service.hotelService.reservation.application.ports.output;

import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;

public interface SaveReservationOutputPort {
    ReservationDomainEntity save(ReservationDomainEntity reservation);
}
