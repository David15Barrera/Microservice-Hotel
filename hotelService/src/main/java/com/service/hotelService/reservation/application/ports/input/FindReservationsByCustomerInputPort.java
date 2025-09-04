package com.service.hotelService.reservation.application.ports.input;

import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindReservationsByCustomerInputPort {
    List<ReservationDomainEntity> findByCustomerId(UUID customerId);
}
