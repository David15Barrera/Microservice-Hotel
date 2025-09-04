package com.service.hotelService.reservation.application.ports.input;

import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;

import java.util.List;

public interface FindAllReservationsInputPort {
    List<ReservationDomainEntity> findAll();

}
