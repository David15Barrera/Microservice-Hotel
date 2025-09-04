package com.service.hotelService.reservation.application.ports.output;

import com.service.hotelService.reservation.domain.model.ReservationDomainEntity;

import java.util.List;

public interface FindAllReservationsOutputPort {
    List<ReservationDomainEntity> findAll();
}
