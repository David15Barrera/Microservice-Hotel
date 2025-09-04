
package com.service.hotelService.reservation.application.ports.output;

import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;

import java.util.UUID;

public interface FindReservationByIdOutputPort {
    ReservationDomainEntity findById(UUID id);
}
